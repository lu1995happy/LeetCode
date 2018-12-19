import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class rally_health {

	public List<String> getAllExp (String input, int target) {
        List<String> list = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return list;
        }
        generateExp(list, input, target, "", 0, 0, 0);
        return list;
    }

    public void generateExp (List<String> list, String input, int target, String currExp, 
    						 long currVal, int pos, long multiVal) {
        if (pos == input.length()) {
            if (currVal == target) {
                list.add(currExp);
            }
            return;
        }

        for (int i = pos; i < input.length(); i++) {
            if (i != pos && input.charAt(pos) == '0') {
                break;
            }

            String str = input.substring(pos, i + 1);
            long curr = Long.parseLong(str);

            if (pos == 0) {
                generateExp(list, input, target, currExp + str, curr, i + 1, curr);
            } else {
                generateExp(list, input, target, currExp + "+" + str, currVal + curr,
                        i + 1, curr);
                generateExp(list, input, target, currExp + "-" + str, currVal - curr,
                        i + 1, -curr);
                generateExp(list, input, target, currExp + "*" + str, currVal - multiVal +
                        multiVal * curr, i + 1, multiVal * curr);
            }
        }
    }

    public static void main(String[] args) {
        rally_health test = new rally_health();
        Scanner input = new Scanner(System.in);
        int target = Integer.parseInt(input.nextLine());
        while (input.hasNext()) {
            String str = input.nextLine();
            List<String> list = test.getAllExp(str, target);
            if (list.size() == 0) {
                System.out.println("Impossible");
                System.out.println();
            } else {
                for (String res : list) {
                    System.out.println(res);
                }
                System.out.println();
            }
        }

    }


}
