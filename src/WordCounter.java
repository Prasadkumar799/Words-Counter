import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

public class WordCounter extends JFrame {

	public static void main(String[] args) {
		 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WordCounter();
			}
		});

	}
	public WordCounter() {
		setTitle("Word Counter");
		setLayout(new BorderLayout());
		JTextArea textArea=new JTextArea(10,30);
		JButton countButton=new JButton("Count words");
		JLabel wordCountLabel=new JLabel("Word Count : 0");
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(countButton,BorderLayout.SOUTH);
		add(wordCountLabel,BorderLayout.NORTH);
		
		countButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text=textArea.getText();
				int wordCount=countWords(text);
				wordCountLabel.setText("Word Count: "+wordCount);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	private int countWords(String text) {
		if(text==null || text.isEmpty()) {
			return 0;
		}
		String[] words=text.trim().split("\\s+");
		return words.length;
	}

}
