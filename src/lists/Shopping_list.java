package lists;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Stack;


public class Shopping_list extends Item_list {

    public Shopping_list(File file) throws IOException {

        super();
        generate_list(file);
    }

    private void generate_list(File file) throws IOException {
        Stack<String> line_stack;

        line_stack = read_File(file);

        for(int i = line_stack.size(); i > 0; i--) {
            Shop_item shop_item;

            shop_item = string_to_item(line_stack.pop());
            items.add(shop_item);
        }
    }

    public void sort_list() {

        int i,j;
        int iMin;

        for (j = 0; j < items.size(); j++) {

            iMin = j;
            for ( i = j+1; i < items.size(); i++) {
                if (items.get(i).getIndex() < items.get(iMin).getIndex()) {
                    iMin = i;
                }
            }

            if(iMin != j) {
                Shop_item temp_i;
                Shop_item temp_iMin;

                temp_i = items.get(i);
                temp_iMin = items.get(iMin);

                items.remove(i);
                items.add(i, temp_iMin);

                items.remove(iMin);
                items.add(iMin,temp_i);

            }

        }
    }

}
