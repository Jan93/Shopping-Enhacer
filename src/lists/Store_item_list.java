package lists;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Store_item_list extends Item_list {

    public Store_item_list(File file) throws IOException{

        super();
        generate_list(file);
    }

    private void generate_list(File file) throws IOException{
        Stack<String> line_stack;

        line_stack = read_File(file);

        for(int i = line_stack.size(); i > 0; i--) {
            Shop_item shop_item;

            shop_item = string_to_item(line_stack.pop());
            shop_item.setIndex(i);

            items.add(shop_item);
        }

    }
}
