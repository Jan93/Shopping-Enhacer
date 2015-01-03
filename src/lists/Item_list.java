package lists;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


  abstract class Item_list {

    protected List<Shop_item> items;

    public Item_list() {
        items = new LinkedList<Shop_item>();
    }

    protected Stack<String> read_File(File file) throws IOException{
        Stack<String> line_stack;

        line_stack = new Stack<String>();


        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            line_stack.add(line);
        }
        br.close();

        return line_stack;
    }

    protected Shop_item string_to_item(String line) throws Broken_Line_Error {
        String name;
        String price;
        Shop_item shop_item;

        try {
            name = line.substring(0, line.indexOf(";"));
            price = line.substring(line.indexOf(";"), line.length());

            shop_item = new Shop_item(name, Integer.parseInt(price));
        } catch (NumberFormatException e) {
            throw new Broken_Line_Error(line, "Number Error");
        } catch (NullPointerException e) {
            throw  new Broken_Line_Error(line, "Semicolon not found");
        }

        return shop_item;
    }

      public List<Shop_item> getItems() {
          return items;
      }

      public void setItems(List<Shop_item> items) {
          this.items = items;
      }
  }
