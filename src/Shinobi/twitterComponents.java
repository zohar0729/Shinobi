package Shinobi;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

class twitterComponent extends JPanel{
	Twitter twitter;
	twitterComponent(Twitter t){
		twitter = t;
		setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}
}
class ProfileArea extends twitterComponent{

	ProfileArea(Twitter t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	
}
class TweetArea extends twitterComponent{
	JPanel buttonPane;
	JTextArea edit;
	JButton send;
	JScrollPane scroll;
	Boolean[] key = new Boolean[2];
	TweetArea(Twitter t){
		super(t);
		
		twitter = t;
		edit = new JTextArea();
		buttonPane = new JPanel();
		send = new JButton("Tweet");
		scroll = new JScrollPane(edit);
		
		edit.setLineWrap(true);
		edit.setWrapStyleWord(true);
		edit.setFont(new Font("‚l‚r@ƒSƒVƒbƒN", Font.PLAIN, 16));
		edit.setMargin(new Insets(5, 100, 5, 100));
		edit.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		edit.requestFocusInWindow();
		send.setMnemonic(KeyEvent.VK_ENTER);
		
		buttonPane.add(send);
		setLayout(new GridLayout(2,1));
		add(scroll);
		add(buttonPane);

		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(edit.getText().length() > 140){
					
				}else if(edit.getText().length() == 0){
					
				}else{
					try {
						Status s = twitter.updateStatus(edit.getText());
						edit.setText(null);
						edit.requestFocusInWindow();
					} catch (TwitterException te) {
						// TODO Auto-generated catch block
						te.printStackTrace();
					}
				}
			}
		});

	}
	
	public String getText(){
		return edit.getText();
	}
	public void setText(String arg0){
		edit.setText(arg0);
	}
}
