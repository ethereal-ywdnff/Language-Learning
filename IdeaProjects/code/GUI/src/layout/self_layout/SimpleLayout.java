package layout.self_layout;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleLayout extends LayoutAdapter{
    List<Component> list = new ArrayList<>();

    @Override
    public void layoutContainer(Container parent) {//调动窗口大小时，改动label
        System.out.println("** layoutContainer...");
        int width = parent.getWidth();
        int height = parent.getHeight();
        //Component[] children = parent.getComponents();

        int x = 0;
        int y = 0;
        for (int i = 0; i < list.size(); i++) {
            Component c = list.get(i);
            c.setBounds(x, y, 100, 100);

            x += 100;
            if (x > width) {//超过宽度时，往下一行
                x = 0;
                y += 100;
            }
        }
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        list.add(comp);
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        list.remove(comp);
    }
}
