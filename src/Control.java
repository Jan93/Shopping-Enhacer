import lists.Shopping_list;
import lists.Store_item_list;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Control {
    private final int MAX_SUPP_FILES = 100;

    private static String STORE_FILE_LOC = "";
    private static String STORE_FILE_NAME = "C:\\Users\\Jan\\Shopping-Enhancer\\out\\production\\Shopping-Enhancer\\Store_File_";

    private static String SHOP_LIST_FILE_LOC = "";
    private static String SHOP_LIST_FILE_NAME = "C:\\Users\\Jan\\Shopping-Enhancer\\out\\production\\Shopping-Enhancer\\Shop_List_File_";

    public Shopping_list shopping_list;
    public List<Store_item_list> store_item_list_List;

    public static void main(String args[]) {

        new Control(Integer.parseInt(args[0]));
    }

    public Control(int store_num) {

        init_lists();

        optimize_list(shopping_list, store_item_list_List.get(store_num));

    }

    private void init_lists() {
        Stack<File> file_stack;

        store_item_list_List = new ArrayList<Store_item_list>();

        file_stack = open_file_stack(SHOP_LIST_FILE_NAME);
        try {
            for (File stack_file : file_stack) {
                shopping_list = new Shopping_list(stack_file);
            }
        } catch(IOException e) {
            write_to_log("IO ERROR");
            System.exit(1337);
        }

        file_stack = open_file_stack(STORE_FILE_NAME);
        try {
            for (File stack_file : file_stack) {
                store_item_list_List.add(new Store_item_list(stack_file));
            }
        } catch(IOException e) {
            write_to_log("IO ERROR");
            System.exit(1338);
        }

    }

    private void optimize_list(Shopping_list shopping_list, Store_item_list store_item_list) {

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
        while (true) {
            if (file.isFile()) {
                return file;
            } else if (fault_index < 20) {
                fault_index++;

            } else {
                throw new FileNotFoundException();
            }
        }

    }

    private void write_to_log(String log_entry) {
        System.out.println(log_entry);
    }
}
