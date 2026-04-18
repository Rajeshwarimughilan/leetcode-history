const axios = require("axios");
const fs = require("fs");
const { execSync } = require("child_process");

const SESSION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfYXV0aF91c2VyX2lkIjoiMTQxNjQ0OTIiLCJfYXV0aF91c2VyX2JhY2tlbmQiOiJhbGxhdXRoLmFjY291bnQuYXV0aF9iYWNrZW5kcy5BdXRoZW50aWNhdGlvbkJhY2tlbmQiLCJfYXV0aF91c2VyX2hhc2giOiJmYWY1YzQ3MDkwMzM2OWMwMDJlZWY1Yzg4ZDk2ZWY5YmMxMjVkYWE3MjdmZGVlYmNiNjAwNzQzYjdhMWE1Y2U4Iiwic2Vzc2lvbl91dWlkIjoiZjQxNDRhYWIiLCJpZCI6MTQxNjQ0OTIsImVtYWlsIjoicmFqZXNod2FyaW11Z2hpbGFuQGdtYWlsLmNvbSIsInVzZXJuYW1lIjoiUmFqZXNod2FyaW11Z2hpbGFuIiwidXNlcl9zbHVnIjoiUmFqZXNod2FyaW11Z2hpbGFuIiwiYXZhdGFyIjoiaHR0cHM6Ly9hc3NldHMubGVldGNvZGUuY29tL3VzZXJzL1JhamVzaHdhcmltdWdoaWxhbi9hdmF0YXJfMTc3NzYyMTQwMS5wbmciLCJyZWZyZXNoZWRfYXQiOjE3Nzc2MjE1NzksImlwIjoiMjQwOTo0MGY0OjMwODA6MjQ5ODo1ZDhkOjQ1NjY6ODBkMzoyOTg0IiwiaWRlbnRpdHkiOiJiODc1NDNlY2JjMGJhNjEwZDlmMDZmOWYyYzQzMmE0NiIsImRldmljZV93aXRoX2lwIjpbImFmZDNlYWE2MDViNjhhZjJlMzI5ODA3ZDlmZmM1NzhmIiwiMjQwOTo0MGY0OjMwODA6MjQ5ODo1ZDhkOjQ1NjY6ODBkMzoyOTg0Il0sIl9zZXNzaW9uX2V4cGlyeSI6MTIwOTYwMH0.WFvDxGY8gmc6G42bihXhcIzmnFL0zh63WEayydijGyM";

const headers = {
  "Content-Type": "application/json",
  "Cookie": `LEETCODE_SESSION=${SESSION}`
};

// 🔹 Fetch submissions (paginated)
async function fetchSubmissions(offset = 0, limit = 20) {
  const res = await axios.post(
    "https://leetcode.com/graphql",
    {
      query: `
        query {
          submissionList(offset: ${offset}, limit: ${limit}) {
            submissions {
              id
              title
              titleSlug
              timestamp
              statusDisplay
            }
          }
        }
      `
    },
    { headers }
  );

  return res.data.data.submissionList.submissions;
}

// 🔹 Fetch code
async function fetchCode(id) {
  const res = await axios.post(
    "https://leetcode.com/graphql",
    {
      query: `
        query {
          submissionDetails(submissionId: ${id}) {
            code
            timestamp
            lang {
              name
            }
          }
        }
      `
    },
    { headers }
  );

  return res.data.data.submissionDetails;
}

// 🔹 Fetch difficulty
async function fetchDifficulty(slug) {
  const res = await axios.post(
    "https://leetcode.com/graphql",
    {
      query: `
        query {
          question(titleSlug: "${slug}") {
            difficulty
          }
        }
      `
    },
    { headers }
  );

  return res.data.data.question.difficulty.toLowerCase();
}

// 🔹 Extension
function getExtension(lang) {
  if (!lang) return "txt";
  if (lang.includes("JavaScript")) return "js";
  if (lang.includes("Python")) return "py";
  if (lang.includes("Java")) return "java";
  return "txt";
}

// 🔹 Commit with date
function commitWithDate(message, date) {
  execSync("git add .");

  execSync(`git commit -m "${message}"`, {
    env: {
      ...process.env,
      GIT_AUTHOR_DATE: date,
      GIT_COMMITTER_DATE: date
    }
  });
}

// 🔥 MAIN (NO DEDUPLICATION)
async function main() {
  let offset = 0;
  const limit = 20;

  console.log("📥 Fetching ALL submissions...");

  while (true) {
    const submissions = await fetchSubmissions(offset, limit);
    if (!submissions.length) break;

    for (let sub of submissions) {
      try {
        // ✅ ONLY ACCEPTED
        if (sub.statusDisplay !== "Accepted") continue;

        console.log(`⚙ Processing ${sub.title} [${sub.id}]`);

        const details = await fetchCode(sub.id);
        if (!details || !details.code) continue;

        const difficulty = await fetchDifficulty(sub.titleSlug);

        if (!fs.existsSync(difficulty)) {
          fs.mkdirSync(difficulty);
        }

        const ext = getExtension(details.lang?.name);

        // 🔥 UNIQUE FILE NAME PER SUBMISSION
        const filePath = `${difficulty}/${sub.titleSlug}-${sub.id}.${ext}`;

        if (fs.existsSync(filePath)) continue;

        fs.writeFileSync(filePath, details.code);

        const date = new Date(details.timestamp * 1000).toISOString();

        commitWithDate(
          `Solved ${sub.title} [Submission ${sub.id}]`,
          date
        );

        await new Promise(r => setTimeout(r, 800));

      } catch (err) {
        console.log("❌ Error:", err.message);
      }
    }

    offset += limit;
  }

  console.log("🚀 Full history created!");
}

main();