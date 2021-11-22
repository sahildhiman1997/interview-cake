import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

    public  class WordCloudData {
        private Map<String, Integer> wordsToCounts = new ConcurrentHashMap<>();
        private void populateWordsToCounts(String inputString)  {

            // count the frequency of each word
            int end = 0, start = 0;
            for (int i = 0; i < inputString.length(); i++) {

                char c = inputString.charAt(i);
                if (!Character.isLetter(c) && (c != '\'' && c !='-')) {
                    addWord(inputString, start, i);
                    while (!Character.isLetter(inputString.charAt(i)) && i < inputString.length() - 2) {
                        i++;
                    }
                    start = i;
                }

            }
            if (Character.isLetter(inputString.charAt(inputString.length() - 1)) || inputString.charAt(inputString.length() - 1) == '\'' || inputString.charAt(inputString.length() - 1) == '-') {
                addWord(inputString, start, inputString.length());
            }


// remove th duplicate shit caused by uppercase
            for (String key : wordsToCounts.keySet()) {
                if (Character.isUpperCase(key.charAt(0)) && wordsToCounts.containsKey(key.toLowerCase())) {
                    wordsToCounts.put(key.toLowerCase(), wordsToCounts.get(key.toLowerCase()) + wordsToCounts.get(key));
                    wordsToCounts.remove(key);
                }
            }
        }


        private void addWord(String inputString, int start, int end) {
            String key = inputString.substring(start, end);
            if (wordsToCounts.containsKey(key)) {
                wordsToCounts.put(key, wordsToCounts.get(key) + 1);
            } else {
                wordsToCounts.put(key, 1);
            }

        }

        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }


        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
    }







