package gui;

import javax.swing.*;
import java.awt.*;

import actions.NextAction;
import actions.PauseAction;
import actions.PlayAction;
import actions.PreviousAction;
import actions.StopAction;
import actions.UnPauseAction;

public class MyTunesGUI extends JFrame {
    private JTable songTable;
    private JButton playButton, stopButton, pauseButton, unpauseButton, nextButton, previousButton;

    public MyTunesGUI() {
        setTitle("MyTunes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Song library table (simplified)
        String[] columnNames = {"Title", "Artist", "Album", "Year", "Genre", "Comment"};
        Object[][] data = {
            {"Affection", "The Lost Boys", null, "unknown", "Other", "Side 1"},
            {"All Things Must Pass", "George Harrison", "All Things Must Pass [Disc 2]", "2001", "Rock", "Side 1"},
            {"Bach: Cantata #12, \"Weinen, Klagen...\"", "Bach, Johann Sebastian", "Bach Sacred Cantatas 012", "1999", "Classical", "000020B 0000246 00004697 00..."},
            {"Bruch No. 1 in A minor", "Bruch, Max", "Bruch: 8 Pieces", "unknown", "unknown", "0000"},
            {"Bruch No. 4 in D minor", "Bruch, Max", "Bruch: 8 Pieces", "unknown", "unknown", "0000"},
            {"Choral", "Bach, Johann Sebastian", "St. John Passion, BWV 245 (Disc 1)", "1998", "Classical", "000002AA 00001B1 0004DFC 00..."},
            {"Four Sticks", "Led Zeppelin", "Led Zeppelin IV", "1971", "Rock", "Side 2"},
            {"Going to California", "Led Zeppelin", "Led Zeppelin IV", "1971", "Rock", "Side 2"},
            {"Haydn: String Quartet #62 In C, 2...", "Haydn, Franz Joseph", "Haydn: String Quartets [Disc 19]", "2001", "Classical", "Movement 2"},
            {"High and Dry", "Radiohead", "The Bends", "1996", "Rock", "Best Radiohead song"},
            {"Karma Police", "Radiohead", "OK Computer", "1997", "Rock", "First Stones hit"},
            {"Last Time", "The Rolling Stones", "The Rolling Stones Greatest Hits", "unknown", "Rock", "First Stones hit"},
            {"Let Down", "Radiohead", "OK Computer", "1997", "Rock", "Last good RH song"},
            {"Misty Mountain Hop", "Led Zeppelin", "Led Zeppelin IV", "1971", "Rock", "Side 2"},
            {"No. 54: Aria \"Widerstehe doch der S...\"", "Bach, Johann Sebastian", "J.S.Bach - Cantatas Nos. 54, 82 & 1...", "unknown", "Classical", "0"},
            {"On Your Shore", "Enya", "Watermark", "1988", "New Age", "A fake comment"},
            {"Perfection", "Badfinger", "Badfinger Greatest Hits", "unknown", "Other", "Last good Badfinger song"},
            {"Ricecar a 6", "Bach, Johann Sebastian", "Musical Offering", "unknown", "unknown", "0000"},
            {"Ruby Tuesday", "The Rolling Stones", "The Rolling Stones Greatest Hits", "unknown", "Rock", "Named after the restaurant"},
            {"Satisfaction", "The Rolling Stones", "The Rolling Stones Greatest Hits", "unknown", "Rock", "I can get some"},
            {"Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", "1971", "Rock", "Side 2"},
            {"Stray Cat Blues", "The Rolling Stones", "The Rolling Stones Greatest Hits", "unknown", "Other", "Cringe-worthy lyrics"},
            {"Street Fighting Man", "The Rolling Stones", "The Rolling Stones Greatest Hits", "unknown", "Other", "Everywhere I hear the sound"},
            {"Sulk", "Radiohead", "The Bends", "1995", "unknown", "Sometimes you burn"},
            {"Sympathy for the Devil", "The Rolling Stones", "The Rolling Stones Greatest Hits", "unknown", "Other", "Rode a tank, held a generals rank"},
            {"The Battle of Evermore", "Led Zeppelin", "Led Zeppelin IV", "1971", "Rock", "Lord of the Rings"},
            {"The Bends", "Radiohead", "The Bends", "1995", "unknown", "0000"},
            {"When the Levee Breaks", "Led Zeppelin", "Led Zeppelin IV", "1971", "Rock", "Where are you now when I needed y..."}
        };
        songTable = new JTable(data, columnNames);
        add(new JScrollPane(songTable), BorderLayout.CENTER);

        // Control buttons
        JPanel controlPanel = new JPanel();
        playButton = new JButton("Play");
        stopButton = new JButton("Stop");
        pauseButton = new JButton("Pause");
        unpauseButton = new JButton("Unpause");
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");

        controlPanel.add(playButton);
        controlPanel.add(stopButton);
        controlPanel.add(pauseButton);
        controlPanel.add(unpauseButton);
        controlPanel.add(nextButton);
        controlPanel.add(previousButton);
        
        add(controlPanel, BorderLayout.SOUTH);
        playButton.addActionListener(new PlayAction());
        stopButton.addActionListener(new StopAction());
        pauseButton.addActionListener(new PauseAction());
        unpauseButton.addActionListener(new UnPauseAction());
        nextButton.addActionListener(new NextAction());
        previousButton.addActionListener(new PreviousAction());

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyTunesGUI().setVisible(true);
            }
        });
    }
}
//compilation: javac -d out MyTunesGUI.java
//