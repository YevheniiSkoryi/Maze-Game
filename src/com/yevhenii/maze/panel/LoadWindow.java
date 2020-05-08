package com.yevhenii.maze.panel;


import com.yevhenii.maze.domain.Player;
import com.yevhenii.maze.service.GameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoadWindow extends JDialog {

    private final JList<Player> loadPlayers;
    private final JLabel select;
    private final JPanel backGroundPanel;

    private final GameService gameService;

    public LoadWindow(GameService gameService) {
        this.select = new JLabel("Choose the game");
        this.loadPlayers = new JList<>();
        this.gameService = gameService;
        this.backGroundPanel = new BackGround();
        backGroundPanel.setLayout(new BorderLayout());
        setContentPane(backGroundPanel);

        loadPlayers.setModel(gameService.loadPlayers());
        loadPlayers.setOpaque(false);

        loadPlayers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    Player pl = loadPlayers.getSelectedValue();
                    gameService.startLevelBasedOnAchievedLevel(pl);
                    dispose();
                }
            }
        });

        select.setFont(new Font("Times new roman", Font.PLAIN, 20));
        backGroundPanel.add(select, BorderLayout.NORTH);
        backGroundPanel.add(new JScrollPane(loadPlayers), BorderLayout.CENTER);

        setTitle("Load game");
        setPreferredSize(new Dimension(450, 250));
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
