class Solution {
    public String[] findWords(String[] words) {

        List<Set<Character>> store = new ArrayList<>();
        Set<Character> s1 = new HashSet<>();
        s1.add('q');s1.add('w');s1.add('e');s1.add('r');s1.add('y');s1.add('t');
        s1.add('u');s1.add('i');s1.add('o');s1.add('p');
        store.add(s1);

        Set<Character> s2 = new HashSet<>();
        s2.add('a');s2.add('s');s2.add('d');s2.add('f');s2.add('g');s2.add('h');
        s2.add('j');s2.add('k');s2.add('l');
        
        store.add(s2);

        Set<Character> s3 = new HashSet<>();
        s3.add('z');s3.add('x');s3.add('c');s3.add('v');s3.add('b');s3.add('n');
        s3.add('m');
        store.add(s3);


        List<String> res = new ArrayList<>();
        for(String w : words){
            if(check(w.toLowerCase(), store)) res.add(w);
        }
        return res.toArray(new String[0]);
    }

    public boolean check(String s,  List<Set<Character>> store){
        int row = 0;
        if(store.get(0).contains(s.charAt(0))) row = 0;
        else if(store.get(1).contains(s.charAt(0))) row = 1;
        else row = 2;

        for(int i = 0; i < s.length(); i++){
            if(!store.get(row).contains(s.charAt(i))) return false;
        }
        return true;
    }
}