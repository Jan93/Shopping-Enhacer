package lists;

/**
 * Created by Jan on 03.01.2015.
 */
public class Broken_Line_Error extends Error{
    String broken_line;
    String cause_break;
    int    line_number;

    public Broken_Line_Error(String broken_line, String cause_break) {

        this.broken_line = broken_line;
        this.line_number = line_number;
    }

    public void add_line_number(int line_number) {
        this.line_number = line_number;
    }

    public String create_error_message() {
        String err_msg;

        err_msg = "Error: Broken Line(line: " + line_number + ") Line text: " + broken_line
                + "Cause of break:" + cause_break;

        return err_msg;
    }
}
