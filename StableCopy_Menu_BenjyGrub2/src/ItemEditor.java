

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ItemEditor {
	
	LogScreen log;
	
	public ItemEditor(LogScreen log)
	{
		this.log = log;
	}
	
	

	protected Shell shell;   String[] burgerName = new String[1000];      String[] burgerPrice = new String[1000]; 
	public Text txtBrg1;     String[] sandwichName = new String[1000];    String[] sandwichPrice = new String[1000]; 
	private Text txtBrg1P;   String[] drinkName = new String[1000];       String[] drinkPrice = new String[1000];
	private Text txtBrg2;  
	private Text txtBrg2P;
	private Text txtBrg3;
	private Text txtBrg3P;
	private Text txtBrg4;
	private Text txtBrg4P;
	private Text txtSand1;
	private Text txtBrg7;
	private Text txtBrg6;
	private Text txtBrg5;
	private Text txtBrg5P;
	private Text txtBrg6P;
	private Text txtBrg7P;
	private Text txtSand1P;
	private Text txtSand5;
	private Text txtSand4;
	private Text txtSand3;
	private Text txtSand2;
	private Text txtSand2P;
	private Text txtSand3P;
	private Text txtSand4P;
	private Text txtSand5P;
	private Text txtDri2;
	private Text txtDri1;
	private Text txtSand7;
	private Text txtSand6;
	private Text txtSand6P;
	private Text txtSand7P;
	private Text txtDri1P;
	private Text txtDri2P;
	private Text txtDri5;
	private Text txtDri4;
	private Text txtDri3;
	private Text txtDri3P;
	private Text txtDri4P;
	private Text txtDri5P;
	private Text txtDri6;
	private Text txtDri6P;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ItemEditor window = new ItemEditor(null);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
		public void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(740, 450));
		shell.setSize(740, 450);
		shell.setLocation(0, 0);
		shell.setText("Item Editor");
		shell.setTouchEnabled(true);
		
		Label lblItemNames = new Label(shell, SWT.NONE);
		lblItemNames.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblItemNames.setBounds(26, 21, 100, 20);
		lblItemNames.setText("Item Names");
		
		Label lblItemPrice = new Label(shell, SWT.NONE);
		lblItemPrice.setText("Item Price");
		lblItemPrice.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblItemPrice.setBounds(216, 21, 100, 20);
		
		txtBrg1 = new Text(shell, SWT.BORDER);
		txtBrg1.setTouchEnabled(true);
		txtBrg1.setText("Beef Burger");
		txtBrg1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg1.setBounds(26, 51, 150, 21);
		
		txtBrg1P = new Text(shell, SWT.BORDER);
		txtBrg1P.setTouchEnabled(true);
		txtBrg1P.setText("5.99");
		txtBrg1P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg1P.setBounds(216, 51, 100, 21);
		
		txtBrg2 = new Text(shell, SWT.BORDER);
		txtBrg2.setTouchEnabled(true);
		txtBrg2.setText("Cheese Burger");
		txtBrg2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg2.setBounds(26, 78, 150, 21);
		
		txtBrg2P = new Text(shell, SWT.BORDER);
		txtBrg2P.setTouchEnabled(true);
		txtBrg2P.setText("6.99");
		txtBrg2P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg2P.setBounds(216, 78, 100, 21);
		
		txtBrg3 = new Text(shell, SWT.BORDER);
		txtBrg3.setTouchEnabled(true);
		txtBrg3.setText("Korean Burger");
		txtBrg3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg3.setBounds(26, 105, 150, 21);
		
		txtBrg3P = new Text(shell, SWT.BORDER);
		txtBrg3P.setTouchEnabled(true);
		txtBrg3P.setText("7.99");
		txtBrg3P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg3P.setBounds(216, 105, 100, 21);
		
		txtBrg4 = new Text(shell, SWT.BORDER);
		txtBrg4.setTouchEnabled(true);
		txtBrg4.setText("Double Beef Burger");
		txtBrg4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg4.setBounds(26, 132, 150, 21);
		
		txtBrg4P = new Text(shell, SWT.BORDER);
		txtBrg4P.setTouchEnabled(true);
		txtBrg4P.setText("7.99");
		txtBrg4P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg4P.setBounds(216, 132, 100, 21);
		
		txtSand1 = new Text(shell, SWT.BORDER);
		txtSand1.setTouchEnabled(true);
		txtSand1.setText("Ham Sandwich");
		txtSand1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand1.setBounds(26, 240, 150, 21);
		
		txtBrg7 = new Text(shell, SWT.BORDER);
		txtBrg7.setTouchEnabled(true);
		txtBrg7.setText("Beef and Mushroom Burger");
		txtBrg7.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg7.setBounds(26, 213, 150, 21);
		
		txtBrg6 = new Text(shell, SWT.BORDER);
		txtBrg6.setTouchEnabled(true);
		txtBrg6.setText("Bacon and Cheese Burger");
		txtBrg6.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg6.setBounds(26, 186, 150, 21);
		
		txtBrg5 = new Text(shell, SWT.BORDER);
		txtBrg5.setTouchEnabled(true);
		txtBrg5.setText("Bacon and Beef Burger");
		txtBrg5.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg5.setBounds(26, 159, 150, 21);
		
		txtBrg5P = new Text(shell, SWT.BORDER);
		txtBrg5P.setTouchEnabled(true);
		txtBrg5P.setText("6.99");
		txtBrg5P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg5P.setBounds(216, 159, 100, 21);
		
		txtBrg6P = new Text(shell, SWT.BORDER);
		txtBrg6P.setTouchEnabled(true);
		txtBrg6P.setText("6.99");
		txtBrg6P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg6P.setBounds(216, 186, 100, 21);
		
		txtBrg7P = new Text(shell, SWT.BORDER);
		txtBrg7P.setTouchEnabled(true);
		txtBrg7P.setText("6.99");
		txtBrg7P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtBrg7P.setBounds(216, 213, 100, 21);
		
		txtSand1P = new Text(shell, SWT.BORDER);
		txtSand1P.setTouchEnabled(true);
		txtSand1P.setText("1.99");
		txtSand1P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand1P.setBounds(216, 240, 100, 21);
		
		txtSand5 = new Text(shell, SWT.BORDER);
		txtSand5.setTouchEnabled(true);
		txtSand5.setText("Cheese Sandwich");
		txtSand5.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand5.setBounds(410, 78, 150, 21);
		
		txtSand4 = new Text(shell, SWT.BORDER);
		txtSand4.setTouchEnabled(true);
		txtSand4.setText("Chicken Sandwich");
		txtSand4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand4.setBounds(410, 51, 150, 21);
		
		txtSand3 = new Text(shell, SWT.BORDER);
		txtSand3.setTouchEnabled(true);
		txtSand3.setText("Lamb Sandwich");
		txtSand3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand3.setBounds(26, 294, 150, 21);
		
		txtSand2 = new Text(shell, SWT.BORDER);
		txtSand2.setTouchEnabled(true);
		txtSand2.setText("Tuna Sandwich");
		txtSand2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand2.setBounds(26, 267, 150, 21);
		
		txtSand2P = new Text(shell, SWT.BORDER);
		txtSand2P.setTouchEnabled(true);
		txtSand2P.setText("2.99");
		txtSand2P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand2P.setBounds(216, 267, 100, 21);
		
		txtSand3P = new Text(shell, SWT.BORDER);
		txtSand3P.setTouchEnabled(true);
		txtSand3P.setText("4.49");
		txtSand3P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand3P.setBounds(216, 294, 100, 21);
		
		txtSand4P = new Text(shell, SWT.BORDER);
		txtSand4P.setTouchEnabled(true);
		txtSand4P.setText("3.99");
		txtSand4P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand4P.setBounds(601, 51, 100, 21);
		
		txtSand5P = new Text(shell, SWT.BORDER);
		txtSand5P.setTouchEnabled(true);
		txtSand5P.setText("1.99");
		txtSand5P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand5P.setBounds(601, 78, 100, 21);
		
		txtDri2 = new Text(shell, SWT.BORDER);
		txtDri2.setTouchEnabled(true);
		txtDri2.setText("Fanta");
		txtDri2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri2.setBounds(410, 186, 150, 21);
		
		txtDri1 = new Text(shell, SWT.BORDER);
		txtDri1.setTouchEnabled(true);
		txtDri1.setText("Water");
		txtDri1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri1.setBounds(410, 159, 150, 21);
		
		txtSand7 = new Text(shell, SWT.BORDER);
		txtSand7.setTouchEnabled(true);
		txtSand7.setText("Beef BBQ Sandwich");
		txtSand7.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand7.setBounds(410, 132, 150, 21);
		
		txtSand6 = new Text(shell, SWT.BORDER);
		txtSand6.setTouchEnabled(true);
		txtSand6.setText("Salmon Sandwich");
		txtSand6.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand6.setBounds(410, 105, 150, 21);
		
		txtSand6P = new Text(shell, SWT.BORDER);
		txtSand6P.setTouchEnabled(true);
		txtSand6P.setText("4.99");
		txtSand6P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand6P.setBounds(601, 105, 100, 21);
		
		txtSand7P = new Text(shell, SWT.BORDER);
		txtSand7P.setTouchEnabled(true);
		txtSand7P.setText("4.99");
		txtSand7P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtSand7P.setBounds(601, 132, 100, 21);
		
		txtDri1P = new Text(shell, SWT.BORDER);
		txtDri1P.setTouchEnabled(true);
		txtDri1P.setText("0.75");
		txtDri1P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri1P.setBounds(601, 159, 100, 21);
		
		txtDri2P = new Text(shell, SWT.BORDER);
		txtDri2P.setTouchEnabled(true);
		txtDri2P.setText("0.99");
		txtDri2P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri2P.setBounds(601, 186, 100, 21);
		
		txtDri5 = new Text(shell, SWT.BORDER);
		txtDri5.setTouchEnabled(true);
		txtDri5.setText("Mango Juice");
		txtDri5.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri5.setBounds(410, 267, 150, 21);
		
		txtDri4 = new Text(shell, SWT.BORDER);
		txtDri4.setTouchEnabled(true);
		txtDri4.setText("Apple Juice");
		txtDri4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri4.setBounds(410, 240, 150, 21);
		
		txtDri3 = new Text(shell, SWT.BORDER);
		txtDri3.setTouchEnabled(true);
		txtDri3.setText("Sprite");
		txtDri3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri3.setBounds(410, 213, 150, 21);
		
		txtDri3P = new Text(shell, SWT.BORDER);
		txtDri3P.setTouchEnabled(true);
		txtDri3P.setText("0.99");
		txtDri3P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri3P.setBounds(601, 213, 100, 21);
		
		txtDri4P = new Text(shell, SWT.BORDER);
		txtDri4P.setTouchEnabled(true);
		txtDri4P.setText("1.49");
		txtDri4P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri4P.setBounds(601, 240, 100, 21);
		
		txtDri5P = new Text(shell, SWT.BORDER);
		txtDri5P.setTouchEnabled(true);
		txtDri5P.setText("1.49");
		txtDri5P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri5P.setBounds(601, 267, 100, 21);
		
		txtDri6 = new Text(shell, SWT.BORDER);
		txtDri6.setTouchEnabled(true);
		txtDri6.setText("Orange Juice");
		txtDri6.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri6.setBounds(410, 294, 150, 21);
		
		txtDri6P = new Text(shell, SWT.BORDER);
		txtDri6P.setTouchEnabled(true);
		txtDri6P.setText("1.49");
		txtDri6P.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtDri6P.setBounds(601, 294, 100, 21);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Item Price");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label.setBounds(601, 21, 100, 20);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Item Names");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_1.setBounds(411, 21, 100, 20);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setAlignment(SWT.RIGHT);
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_2.setBounds(198, 52, 15, 20);
		label_2.setText("\u00A3");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setAlignment(SWT.RIGHT);
		label_3.setText("\u00A3");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_3.setBounds(198, 79, 15, 20);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setAlignment(SWT.RIGHT);
		label_4.setText("\u00A3");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_4.setBounds(198, 133, 15, 20);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setAlignment(SWT.RIGHT);
		label_5.setText("\u00A3");
		label_5.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_5.setBounds(198, 106, 15, 20);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setAlignment(SWT.RIGHT);
		label_6.setText("\u00A3");
		label_6.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_6.setBounds(198, 241, 15, 20);
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setAlignment(SWT.RIGHT);
		label_7.setText("\u00A3");
		label_7.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_7.setBounds(198, 214, 15, 20);
		
		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setAlignment(SWT.RIGHT);
		label_8.setText("\u00A3");
		label_8.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_8.setBounds(198, 187, 15, 20);
		
		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setAlignment(SWT.RIGHT);
		label_9.setText("\u00A3");
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_9.setBounds(198, 160, 15, 20);
		
		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setAlignment(SWT.RIGHT);
		label_10.setText("\u00A3");
		label_10.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_10.setBounds(198, 295, 15, 20);
		
		Label label_11 = new Label(shell, SWT.NONE);
		label_11.setAlignment(SWT.RIGHT);
		label_11.setText("\u00A3");
		label_11.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_11.setBounds(198, 268, 15, 20);
		
		Label label_12 = new Label(shell, SWT.NONE);
		label_12.setAlignment(SWT.RIGHT);
		label_12.setText("\u00A3");
		label_12.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_12.setBounds(585, 52, 15, 20);
		
		Label label_13 = new Label(shell, SWT.NONE);
		label_13.setAlignment(SWT.RIGHT);
		label_13.setText("\u00A3");
		label_13.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_13.setBounds(585, 79, 15, 20);
		
		Label label_14 = new Label(shell, SWT.NONE);
		label_14.setAlignment(SWT.RIGHT);
		label_14.setText("\u00A3");
		label_14.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_14.setBounds(585, 106, 15, 20);
		
		Label label_15 = new Label(shell, SWT.NONE);
		label_15.setAlignment(SWT.RIGHT);
		label_15.setText("\u00A3");
		label_15.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_15.setBounds(585, 133, 15, 20);
		
		Label label_16 = new Label(shell, SWT.NONE);
		label_16.setAlignment(SWT.RIGHT);
		label_16.setText("\u00A3");
		label_16.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_16.setBounds(585, 160, 15, 20);
		
		Label label_17 = new Label(shell, SWT.NONE);
		label_17.setAlignment(SWT.RIGHT);
		label_17.setText("\u00A3");
		label_17.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_17.setBounds(585, 187, 15, 20);
		
		Label label_18 = new Label(shell, SWT.NONE);
		label_18.setAlignment(SWT.RIGHT);
		label_18.setText("\u00A3");
		label_18.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_18.setBounds(585, 214, 15, 20);
		
		Label label_19 = new Label(shell, SWT.NONE);
		label_19.setAlignment(SWT.RIGHT);
		label_19.setText("\u00A3");
		label_19.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_19.setBounds(585, 241, 15, 20);
		
		Label label_20 = new Label(shell, SWT.NONE);
		label_20.setAlignment(SWT.RIGHT);
		label_20.setText("\u00A3");
		label_20.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_20.setBounds(585, 268, 15, 20);
		
		Label label_21 = new Label(shell, SWT.NONE);
		label_21.setAlignment(SWT.RIGHT);
		label_21.setText("\u00A3");
		label_21.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_21.setBounds(585, 295, 15, 20);
		
		Button btnStats = new Button(shell, SWT.NONE);
		btnStats.setTouchEnabled(true);
		btnStats.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.statsOpen =true;
				log.stats.open();
			}
		});
		btnStats.setText("Statistics");
		btnStats.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnStats.setBounds(621, 350, 80, 30);
		
		
		
	    Button btnBack = new Button(shell,SWT.NONE);
	    btnBack.setTouchEnabled(true);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.open();
			}
		});
		btnBack.setText("Back");
		btnBack.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnBack.setBounds(26, 350, 80, 30);
		
		Button btnApply = new Button(shell,SWT.NONE);
		btnApply.setTouchEnabled(true);
		btnApply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setItems();
			}
		});
		btnApply.setText("Apply");
		btnApply.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnApply.setBounds(300, 350, 80, 30);


	}
		
		public void setItems()
		{
			// get the value of burger name and price
			burgerName[0]= txtBrg1.getText();  burgerPrice[0]= txtBrg1P.getText(); 
			burgerName[1]= txtBrg2.getText();  burgerPrice[1]= txtBrg2P.getText(); 
			burgerName[2]= txtBrg3.getText();  burgerPrice[2]= txtBrg3P.getText(); 
			burgerName[3]= txtBrg4.getText();  burgerPrice[3]= txtBrg4P.getText(); 
			burgerName[4]= txtBrg5.getText();  burgerPrice[4]= txtBrg5P.getText(); 
			burgerName[5]= txtBrg6.getText();  burgerPrice[5]= txtBrg6P.getText(); 
			burgerName[6]= txtBrg7.getText();  burgerPrice[6]= txtBrg7P.getText(); 
			
			// get the value of sandwich name and price
			sandwichName[0] = txtSand1.getText(); sandwichPrice[0] = txtSand1P.getText();
			sandwichName[1] = txtSand2.getText(); sandwichPrice[1] = txtSand2P.getText();
			sandwichName[2] = txtSand3.getText(); sandwichPrice[2] = txtSand3P.getText();
			sandwichName[3] = txtSand4.getText(); sandwichPrice[3] = txtSand4P.getText();
			sandwichName[4] = txtSand5.getText(); sandwichPrice[4] = txtSand5P.getText();
			sandwichName[5] = txtSand6.getText(); sandwichPrice[5] = txtSand6P.getText();
			sandwichName[6] = txtSand7.getText(); sandwichPrice[6] = txtSand7P.getText();
			
			// get the value of sandwich name and price
			drinkName[0]= txtDri1.getText();  drinkPrice[0]= txtDri1P.getText();
			drinkName[1]= txtDri2.getText();  drinkPrice[1]= txtDri2P.getText();
			drinkName[2]= txtDri3.getText();  drinkPrice[2]= txtDri3P.getText();
			drinkName[3]= txtDri4.getText();  drinkPrice[3]= txtDri4P.getText();
			drinkName[4]= txtDri5.getText();  drinkPrice[4]= txtDri5P.getText();
			drinkName[5]= txtDri6.getText();  drinkPrice[5]= txtDri6P.getText();
		}

}
