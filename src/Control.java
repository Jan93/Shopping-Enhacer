import lists.Shopping_list;
import lists.Store_item_list;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Control {
    private final int MAX_SUPP_FILES = 100;

    private static String STORE_FILE_LOC = "";
    private static String STORE_FILE_NAME = "Store_File_";

    private static String SHOP_LIST_FILE_LOC = "";
    private static String SHOP_LIST_FILE_NAME = "Shop_List_File_";

    public List<Shopping_list> shopping_list_List;
    public List<Store_item_list> store_item_list_List;

    public static void main(String args[]) {
        new Control();
    }

    public Control() {
        Stack<File> file_stack;

        store_item_list_List = new ArrayList<Store_item_list>();
        shopping_list_List = new ArrayList<Shopping_list>();

        file_stack = open_file_stack(SHOP_LIST_FILE_LOC + '\\' + SHOP_LIST_FILE_NAME);
        try {
            for (File stack_file : file_stack) {
                shopping_list_List.add(new Shopping_list(stack_file));
            }
        } catch(IOException e) {
            write_to_log("IO ERROR");
            System.exit(1337);
        }

        file_stack = open_file_stack(STORE_FILE_LOC + '\\' + STORE_FILE_NAME);
        try {
            for (File stack_file : file_stack) {
                store_item_list_List.add(new Store_item_list(stack_file));
            }
        } catch(IOException e) {
            write_to_log("IO ERROR");
            System.exit(1338);
        }

    }

    private boolean optimize_list(Shopping_list shopping_list, Store_item_list store_item_list) {

        return false;
    }

    private Stack<File> open_file_stack(String file_names) {
        Stack<File> file_stack;
        String file_name;

        file_stack = new Stack<File>();

        try {
            for(int i = 0; i < MAX_SUPP_FILES; i++) {
                file_name = file_names + "" + i;
                file_stack.add(open_file(file_name));
            }
        } catch (FileNotFoundException e) {
            if(file_stack.isEmpty()) {
                write_to_log("ERROR: No files found (err 21)");
                System.exit(21);
            } else {
                write_to_log("File read Complete");
            }

        } catch (UnknownError e) {
            write_to_log("ERROR: Something went wrong, try again (err 42)");
            System.exit(42);
        }

        return file_stack;
    }

    private File open_file(String file_name) throws FileNotFoundException, UnknownError{
        File file;
        int fault_index = 0;

        file = new File(file_name);

        try {
            while (true) {
                if (file.isFile()) {
                    return file;
                } else if (fault_index < 20) {
                    fault_index++;
                    wait(100);

                } else {
                    throw new FileNotFoundException();
                }
            }
        } catch (InterruptedException e) {
            throw new UnknownError();
        }

    }

    private void write_to_log(String log_entry) {
        System.out.println(log_entry);
    }
}
