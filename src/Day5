import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {

    public static void main(String[] args) {
        RulesAndUpdates rulesAndUpdates = getRulesAndUpdates();
        List<Rule> rules = rulesAndUpdates.getRules();
        List<List<String>> updates = rulesAndUpdates.getUpdates();
        long totalCorrectOrdered = 0;
        long totalIncorrectOrderedInitially = 0;
        for(List<String> update : updates) {
            if(isUpdateCorrectlyOrdered(update, rules)) {
                totalCorrectOrdered += Long.parseLong(update.get(update.size() / 2));
            } else {
                List<String> correctlyUpdate = getUpdateCorrected(update, rules);
                while(!isUpdateCorrectlyOrdered(correctlyUpdate, rules)) {
                    correctlyUpdate = getUpdateCorrected(correctlyUpdate, rules);
                }
                totalIncorrectOrderedInitially += Long.parseLong(correctlyUpdate.get(correctlyUpdate.size() / 2));
            }
        }
        System.out.println("Total correctly ordered " + totalCorrectOrdered);
        System.out.println("Total incorrectly ordered initially " + totalIncorrectOrderedInitially);
    }

    public static boolean isUpdateCorrectlyOrdered(List<String> update, List<Rule> rules) {
        for(int i = 0; i < update.size() - 1; i++) {
            if(!isUpdateValid(update, rules, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUpdateValid(List<String> update, List<Rule> rules, int i) {
        int before = Integer.parseInt(update.get(i));
        int after = Integer.parseInt(update.get(i + 1));
        boolean isBefore = false;
        for(Rule rule : rules) {
            if(rule.isRuleApplied(before, after)) {
                isBefore = true;
                break;
            }
        }
        return isBefore;
    }

    public static List<String> getUpdateCorrected(List<String> update, List<Rule> rules) {
        List<String> correctedUpdate = new ArrayList<>();
        for(int i = 0; i < update.size() - 1; i++) {
            if(!isUpdateValid(update, rules, i)) {
                correctedUpdate.add(update.get(i + 1));
                correctedUpdate.add(update.get(i));
                i++;
            } else {
                correctedUpdate.add(update.get(i));
            }
            if(i == update.size() - 2) {
                correctedUpdate.add(update.get(i + 1));
            }
        }
        return correctedUpdate;
    }

    public static RulesAndUpdates getRulesAndUpdates() {
        String filePath = "/Users/aubin/Downloads/day5.txt";
        List<Rule> rules = new ArrayList<>();
        List<List<String>> updates = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("|")) {
                    String[] split = line.split("\\|");
                    rules.add(new Rule(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
                }
                if(line.contains(",")) {
                    List<String> update = Arrays.asList(line.split(","));
                    updates.add(update);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RulesAndUpdates(rules, updates);
    }

    public static class RulesAndUpdates {
        private final List<Rule> rules;
        private final List<List<String>> updates;

        public RulesAndUpdates(List<Rule> rules, List<List<String>> updates) {
            this.rules = rules;
            this.updates = updates;
        }

        public List<Rule> getRules() {
            return rules;
        }

        public List<List<String>> getUpdates() {
            return updates;
        }
    }

    public static class Rule {
        private final int before;
        private final int after;

        public Rule(int before, int after) {
            this.before = before;
            this.after = after;
        }

        public boolean isRuleApplied(int before, int after) {
            return this.before == before && this.after == after;
        }

        @Override
        public String toString() {
            return before + " must be before " + after;
        }
    }
}
