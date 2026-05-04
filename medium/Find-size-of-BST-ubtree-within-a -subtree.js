class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

function largestBST(root) {
  let maxSize = 0;

  function dfs(node) {
    if (!node) {
      return {
        isBST: true,
        size: 0,
        min: Infinity,
        max: -Infinity
      };
    }

    let left = dfs(node.left);
    let right = dfs(node.right);

    if (
      left.isBST &&
      right.isBST &&
      node.val > left.max &&
      node.val < right.min
    ) {
      let size = left.size + right.size + 1;
      maxSize = Math.max(maxSize, size);

      return {
        isBST: true,
        size: size,
        min: Math.min(node.val, left.min),
        max: Math.max(node.val, right.max)
      };
    } else {
      return {
        isBST: false,
        size: Math.max(left.size, right.size),
        min: -Infinity,
        max: Infinity
      };
    }
  }

  dfs(root);
  return maxSize;
}