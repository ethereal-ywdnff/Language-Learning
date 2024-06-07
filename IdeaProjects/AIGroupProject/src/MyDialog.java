import javax.swing.*;

public class MyDialog {
    public static boolean showDialog() {
        String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};
        int response = JOptionPane.showOptionDialog(null, "Choose an option:", "Title",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (response == 0) {
            return true;
        } else {
            return false;
        }
    }
}

