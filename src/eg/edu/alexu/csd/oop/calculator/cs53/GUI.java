package eg.edu.alexu.csd.oop.calculator.cs53;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class GUI {

	private JFrame frame;
	String s;
	String history = "";
	boolean flag = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Calculator imp = new Calc();
		frame = new JFrame();
		frame.setForeground(new Color(255, 255, 255));
		frame.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		frame.setBackground(new Color(0, 0, 0));
		frame.setBounds(200, 200, 755, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(160, 82, 45));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextPane txt = new JTextPane();
		txt.setForeground(Color.WHITE);
		txt.setFont(new Font("Segoe UI", Font.ITALIC, 50));
		txt.setOpaque(false);
		txt.setBounds(26, 49, 516, 100);
		panel.add(txt);
		panel.add(txt);

		JLabel label = new JLabel("");
		label.setBounds(370, 13, 172, 50);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 20));
		label.setForeground(new Color(255, 255, 255));
		panel.add(label);

		JButton btn7 = new JButton("7");
		btn7.setBounds(130, 264, 100, 100);
		btn7.setForeground(Color.WHITE);
		btn7.setBackground(new Color(128, 128, 128));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn7.getText());
				} else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn7.setBorder(null);
		btn7.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btn7);

		JButton btn4 = new JButton("4");
		btn4.setBounds(130, 368, 100, 100);
		btn4.setForeground(Color.WHITE);
		btn4.setBackground(new Color(128, 128, 128));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					txt.setText(txt.getText() + btn4.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn4.setBorder(null);
		btn4.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btn4);

		JButton btn1 = new JButton("1");
		btn1.setBounds(130, 472, 100, 100);
		btn1.setForeground(Color.WHITE);
		btn1.setBackground(new Color(128, 128, 128));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn1.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn1.setBorder(null);
		btn1.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btn1);

		JButton btna = new JButton("\u00B1");
		btna.setBounds(130, 160, 100, 100);
		btna.setBackground(Color.LIGHT_GRAY);
		btna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					if (txt.getText().length() > 0) {
						String num = "-" + txt.getText();
						txt.setText(num);
					}
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btna.setBorder(null);
		btna.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btna);

		JButton btni = new JButton("C");
		btni.setBounds(234, 160, 100, 100);
		btni.setBackground(Color.LIGHT_GRAY);
		btni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imp.input(null);
				txt.setText(null);
				label.setText(null);

			}
		});
		btni.setBorder(null);
		btni.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btni);

		JButton btn8 = new JButton("8");
		btn8.setBounds(234, 264, 100, 100);
		btn8.setForeground(Color.WHITE);
		btn8.setBackground(new Color(128, 128, 128));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn8.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn8.setBorder(null);
		btn8.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btn8);

		JButton btn5 = new JButton("5");
		btn5.setBounds(234, 368, 100, 100);
		btn5.setForeground(Color.WHITE);
		btn5.setBackground(new Color(128, 128, 128));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn5.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn5.setBorder(null);
		btn5.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btn5);

		JButton btn2 = new JButton("2");
		btn2.setBounds(234, 472, 100, 100);
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(new Color(128, 128, 128));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn2.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn2.setBorder(null);
		btn2.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btn2);

		JButton btn0 = new JButton("0");
		btn0.setBounds(130, 576, 204, 100);
		btn0.setForeground(Color.WHITE);
		btn0.setBackground(new Color(128, 128, 128));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn0.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn0.setBorder(null);
		btn0.setFont(new Font("SansSerif", Font.ITALIC, 30));
		panel.add(btn0);

		JButton btn9 = new JButton("9");
		btn9.setBounds(338, 264, 100, 100);
		btn9.setForeground(Color.WHITE);
		btn9.setBackground(new Color(128, 128, 128));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn9.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn9.setBorder(null);
		btn9.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 30));
		panel.add(btn9);

		JButton btn6 = new JButton("6");
		btn6.setBounds(338, 368, 100, 100);
		btn6.setForeground(Color.WHITE);
		btn6.setBackground(new Color(128, 128, 128));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn6.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn6.setBorder(null);
		btn6.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 30));
		panel.add(btn6);

		JButton btn3 = new JButton("3");
		btn3.setBounds(338, 472, 100, 100);
		btn3.setForeground(Color.WHITE);
		btn3.setBackground(new Color(128, 128, 128));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					txt.setText(txt.getText() + btn3.getText());
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btn3.setBorder(null);
		btn3.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 30));
		panel.add(btn3);

		JButton btnb = new JButton(".");
		btnb.setForeground(Color.WHITE);
		btnb.setBounds(338, 576, 100, 100);
		btnb.setBackground(new Color(128, 128, 128));
		btnb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag) {
				if (!txt.getText().toString().contains(".")) {
					char[] chars = txt.getText().toCharArray();
					StringBuilder sb = new StringBuilder();
					for (char c : chars) {
						if (Character.isDigit(c)) {
							sb.append(c);
						}
					}
					if (sb.toString().isEmpty()) {
						txt.setText("0" + btnb.getText());
					} else {
						txt.setText(txt.getText() + btnb.getText());

					}
				}}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}

			}
		});
		btnb.setBorder(null);
		btnb.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 30));
		panel.add(btnb);

		JButton btng = new JButton("\u00F7");
		btng.setBounds(442, 160, 100, 100);
		btng.setForeground(Color.WHITE);
		btng.setBackground(new Color(210, 180, 140));
		btng.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(flag) {
				if (txt.getText().length() > 0) {
					if (txt.getText() == "") {
						s = null;
						label.setText("");
						txt.setText("");
					} else if (txt.getText() == ".") {
						s = 0 + " / ";
						label.setText("0" + " / ");
						txt.setText("");
					} else if (s == null) {
						s = txt.getText() + " / ";
						label.setText(txt.getText() + " / ");
						txt.setText("");
					} else {
						label.setText(s);

					}
				}}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}

			}
		});
		btng.setBorder(null);
		btng.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 30));
		panel.add(btng);

		JButton btnf = new JButton("\u00D7\t");
		btnf.setBounds(442, 264, 100, 100);
		btnf.setForeground(Color.WHITE);
		btnf.setBackground(new Color(210, 180, 140));
		btnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag) {
				if (txt.getText().length() > 0) {
					if (txt.getText() == "") {
						s = null;
						label.setText("");
						txt.setText("");
					} else if (txt.getText() == ".") {
						s = 0 + " * ";
						label.setText("0" + " * ");
						txt.setText("");
					} else if (s == null) {
						s = txt.getText() + " * ";
						label.setText(txt.getText() + " * ");
						txt.setText("");
					} else {
						label.setText(s);

					}
				}}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}

			}
		});
		btnf.setBorder(null);
		btnf.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 30));
		panel.add(btnf);

		JButton btne = new JButton("-");
		btne.setBounds(442, 368, 100, 100);
		btne.setForeground(Color.WHITE);
		btne.setBackground(new Color(210, 180, 140));
		btne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag) {
				if (txt.getText().length() > 0) {
					if (txt.getText() == "") {
						s = null;
						label.setText("");
						txt.setText("");
					} else if (txt.getText() == ".") {
						s = 0 + " - ";
						label.setText("0" + " - ");
						txt.setText("");
					} else if (s == null) {
						s = txt.getText() + " - ";
						label.setText(txt.getText() + " - ");
						txt.setText("");
					} else {
						label.setText(s);

					}
				}}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
		});
		btne.setBorder(null);
		btne.setFont(new Font("Simplified Arabic", Font.BOLD | Font.ITALIC, 30));
		panel.add(btne);

		JButton btnd = new JButton("+");
		btnd.setBounds(442, 472, 100, 100);
		btnd.setForeground(Color.WHITE);
		btnd.setBackground(new Color(210, 180, 140));
		btnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag) {
				if (txt.getText().length() > 0) {
					if (txt.getText() == "") {
						s = null;
						label.setText("");
						txt.setText("");
					} else if (txt.getText() == ".") {
						s = 0 + " + ";
						label.setText("0" + " + ");
						txt.setText("");
					} else if (s == null) {
						s = txt.getText() + " + ";
						label.setText(txt.getText() + " + ");
						txt.setText("");
					} else {
						label.setText(s);
					}
				}else if (flag == false) {
					if(txt.getText() == "") {
						flag = true;
					}
				}
			}
			}});
		btnd.setBorder(null);
		btnd.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 30));
		panel.add(btnd);

		UIManager.put("TabbedPane.contentOpaque", false);
		
				JTextPane Tarea = new JTextPane();
				Tarea.setBounds(568, 81, 155, 595);
				panel.add(Tarea);
				Tarea.setForeground(Color.WHITE);
				Tarea.setBorder(null);
				Tarea.setFont(new Font("SansSerif", Font.ITALIC, 22));
				Tarea.setOpaque(false);
				Tarea.setAutoscrolls(false);
				Tarea.setLayout(null);

		JButton btnc = new JButton("=");
		btnc.setBounds(442, 576, 100, 100);
		btnc.setForeground(Color.WHITE);
		btnc.setBackground(new Color(210, 180, 140));
		btnc.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String op;
				if (txt.getText().length() > 0 && s != null) {
					s = s + txt.getText();
					imp.input(s);
					op = imp.getResult();
					label.setText(op);
					txt.setText("");
					history = history + "\n" + s + " = " + op;
					Tarea.setText(history);
					imp.input(null);
					s = null;
					flag = true;
				} else if ((txt.getText().toString().contains("/") || txt.getText().toString().contains("*")
						|| txt.getText().toString().contains("-") || txt.getText().toString().contains("+"))
						&& s == null) {
					s = txt.getText();
					if (s.contains("-")) {
						if (s.startsWith("-")) {
							String str1 = s;
							StringBuilder tri = new StringBuilder(s);
							tri.deleteCharAt(0);
							str1 = tri.toString();
							if (str1.contains("-")) {
								imp.input(s);
								op = imp.getResult();
								label.setText(op);
								txt.setText("");
								imp.input(null);
								s = null;
								flag = true;
							}

						} else {
							imp.input(s);
							op = imp.getResult();
							label.setText(op);
							txt.setText("");
							imp.input(null);
							s = null;
							flag = true;

						}

					} else {
						imp.input(s);
						op = imp.getResult();
						label.setText(op);
						txt.setText("");
						imp.input(null);
						s = null;
						flag = true;
					}
				}
			}
		});
		btnc.setBorder(null);
		btnc.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 30));
		panel.add(btnc);

		JButton btnCurrent = new JButton("Current");
		btnCurrent.setBounds(26, 160, 100, 100);
		btnCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String current = imp.current();
				if (current != "") {
					txt.setText(current);
					label.setText("");
					s=null;
					flag = false;
				}
			}
		});
		btnCurrent.setBackground(Color.LIGHT_GRAY);
		btnCurrent.setBorder(null);
		btnCurrent.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		panel.add(btnCurrent);

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(26, 264, 100, 100);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String next = imp.next();
				if (next != "") {
					txt.setText(next);
					label.setText("");
					s=null;
					flag = false;
				}

			}
		});
		btnNext.setBackground(Color.LIGHT_GRAY);
		btnNext.setBorder(null);
		btnNext.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		panel.add(btnNext);

		JButton btnPrev = new JButton("Prev");
		btnPrev.setBounds(26, 368, 100, 100);
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prev = imp.prev();
				if (prev != "") {
					txt.setText(prev);
					s=null;
					label.setText("");
					flag = false;
				}

			}
		});
		btnPrev.setBackground(Color.LIGHT_GRAY);
		btnPrev.setBorder(null);
		btnPrev.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		panel.add(btnPrev);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(26, 472, 100, 100);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imp.save();
			}
		});
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setBorder(null);
		btnSave.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		panel.add(btnSave);

		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(26, 576, 100, 100);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imp.load();
				
			}
		});
		btnLoad.setBackground(Color.LIGHT_GRAY);
		btnLoad.setBorder(null);
		btnLoad.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		panel.add(btnLoad);

		JButton button = new JButton("\u232B");
		button.setBounds(338, 160, 100, 100);
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == true) {
					String Bcsp = null;
					if (txt.getText().length() > 0) {
						StringBuilder str = new StringBuilder(txt.getText());
						str.deleteCharAt(txt.getText().length() - 1);
						Bcsp = str.toString();
						txt.setText(Bcsp);
					}
				}
			}
		});
		button.setFont(new Font("SansSerif", Font.ITALIC, 30));
		button.setBorder(null);
		panel.add(button);
		
		JTextPane txtpnHistory = new JTextPane();
		txtpnHistory.setDisabledTextColor(new Color(255, 255, 255));
		txtpnHistory.setBackground(new Color(255, 255, 255));
		txtpnHistory.setForeground(new Color(210, 180, 140));
		txtpnHistory.setText("History");
		txtpnHistory.setOpaque(false);
		txtpnHistory.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		txtpnHistory.setBounds(562, 40, 187, 40);
		panel.add(txtpnHistory);
		}
}
