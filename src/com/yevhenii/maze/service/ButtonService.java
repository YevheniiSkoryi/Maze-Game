package com.yevhenii.maze.service;

import javax.swing.*;
import java.awt.*;

public interface ButtonService {

   default void configureButton(JButton... buttons) {
       final Font font = new Font("Times new roman", Font.BOLD, 16);
       for (JButton button : buttons) {
           button.setContentAreaFilled(false);
           button.setBorderPainted(false);
           button.setFont(font);
       }
   }
}
