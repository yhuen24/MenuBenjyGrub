import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;


public class SandwichMenu {
		
	LogScreen log;
	public SandwichMenu(LogScreen log)
	{
		this.log = log;
	}
	
	protected Shell shell;
	int counter[] = {0,0,0,0,0,0,0};
	Text swcounter1; Label lblSand1; Label lblPrice1; float sandPrice1;
	Text swcounter2; Label lblSand2; Label lblPrice2; float sandPrice2;
	Text swcounter3; Label lblSand3; Label lblPrice3; float sandPrice3;
	Text swcounter4; Label lblSand4; Label lblPrice4; float sandPrice4;
	Text swcounter5; Label lblSand5; Label lblPrice5; float sandPrice5;
	Text swcounter6; Label lblSand6; Label lblPrice6; float sandPrice6;
	Text swcounter7; Label lblSand7; Label lblPrice7; float sandPrice7;

	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SandwichMenu window = new SandwichMenu(null);
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
		initialValue();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	// holds the value of each counter and pass it to Text at start
	public void initialValue()
	{
		if(log.managerOpen)
		{
			lblSand1.setText(log.item.sandwichName[0]);
			lblSand2.setText(log.item.sandwichName[1]);
			lblSand3.setText(log.item.sandwichName[2]);
			lblSand4.setText(log.item.sandwichName[3]);
			lblSand5.setText(log.item.sandwichName[4]);
			lblSand6.setText(log.item.sandwichName[5]);
			lblSand7.setText(log.item.sandwichName[6]);
			
			lblPrice1.setText(log.item.sandwichPrice[0]);
			lblPrice2.setText(log.item.sandwichPrice[1]);
			lblPrice3.setText(log.item.sandwichPrice[2]);
			lblPrice4.setText(log.item.sandwichPrice[3]);
			lblPrice5.setText(log.item.sandwichPrice[4]);
			lblPrice6.setText(log.item.sandwichPrice[5]);
			lblPrice7.setText(log.item.sandwichPrice[6]);
		}
		swcounter1.setText(String.valueOf(counter[0]));
		swcounter2.setText(String.valueOf(counter[1]));
		swcounter3.setText(String.valueOf(counter[2]));
		swcounter4.setText(String.valueOf(counter[3]));
		swcounter5.setText(String.valueOf(counter[4]));
		swcounter6.setText(String.valueOf(counter[5]));
		swcounter7.setText(String.valueOf(counter[6]));
		
		sandPrice1 = Float.parseFloat(lblPrice1.getText());
		sandPrice2 = Float.parseFloat(lblPrice2.getText());
		sandPrice3 = Float.parseFloat(lblPrice3.getText());
		sandPrice4 = Float.parseFloat(lblPrice4.getText());
		sandPrice5 = Float.parseFloat(lblPrice5.getText());
		sandPrice6 = Float.parseFloat(lblPrice6.getText());
		sandPrice7 = Float.parseFloat(lblPrice7.getText());	
	}
	
	//calculate the total price for sandwiches
	public float totalPriceSandwich()
	{
		float sandwichTotal=0;
		sandwichTotal =(sandPrice1 *(float)counter[0])+(sandPrice2 *(float)counter[1])+(sandPrice3 *(float)counter[2])+(sandPrice4 *(float)counter[3])+(sandPrice5 *(float)counter[4])+(sandPrice6 *(float)counter[5])+(sandPrice7 *(float)counter[6]) ;
		return sandwichTotal;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setTouchEnabled(true);
		shell.setMinimumSize(new Point(450, 400));
		shell.setSize(450, 400);
		shell.setText("Sandwich Menu");
		shell.setLocation(0,0);
		Button btnBurgers = new Button(shell, SWT.NONE);
		btnBurgers.setTouchEnabled(true);
		btnBurgers.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnBurgers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.burger_menu.open();
				
			}
		});
		btnBurgers.setBounds(30, 30, 85, 40);
		btnBurgers.setText("Burgers");
		
		Button btnDrinks = new Button(shell, SWT.NONE);
		btnDrinks.setTouchEnabled(true);
		btnDrinks.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnDrinks.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.drink_menu.open();
			}
		});
		btnDrinks.setBounds(310, 30, 85, 40);
		btnDrinks.setText("Drinks");
		
		Button btnSandwiches = new Button(shell, SWT.NONE);
		btnSandwiches.setTouchEnabled(true);
		btnSandwiches.setEnabled(false);
		btnSandwiches.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnSandwiches.setBounds(155, 30, 115, 40);
		btnSandwiches.setText("Sandwiches");
		
		Button MinButton1 = new Button(shell, SWT.NONE);
		MinButton1.setTouchEnabled(true);
		MinButton1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[0]>0)
				{
					counter[0]--;
					swcounter1.setText(String.valueOf(counter[0]));
					log.burger_menu.list.remove(lblSand1.getText().concat("  £"+lblPrice1.getText()));
				}
			}
		});
		MinButton1.setText("-");
		MinButton1.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton1.setBounds(260, 95, 20, 20);
		
		swcounter1 = new Text(shell, SWT.BORDER);
		swcounter1.setTouchEnabled(true);
		swcounter1.setText("0");
		swcounter1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		swcounter1.setBounds(286, 93, 35, 20);
		
		Button AddButton1 = new Button(shell, SWT.NONE);
		AddButton1.setTouchEnabled(true);
		AddButton1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[0]++;
				swcounter1.setText(String.valueOf(counter[0]));
				log.burger_menu.list.add(lblSand1.getText().concat("  £"+lblPrice1.getText()));
			}
		});
		AddButton1.setText("+");
		AddButton1.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton1.setBounds(327, 95, 20, 20);
		
		Button MinButton2 = new Button(shell, SWT.NONE);
		MinButton2.setTouchEnabled(true);
		MinButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[1]>0)
				{
					counter[1]--;
					swcounter2.setText(String.valueOf(counter[1]));
					log.burger_menu.list.remove(lblSand2.getText().concat("  £"+lblPrice2.getText()));
				}
			}
		});
		MinButton2.setText("-");
		MinButton2.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton2.setBounds(260, 120, 20, 20);
		
		swcounter2 = new Text(shell, SWT.BORDER);
		swcounter2.setTouchEnabled(true);
		swcounter2.setText("0");
		swcounter2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		swcounter2.setBounds(286, 120, 35, 20);
		
		Button AddButton2 = new Button(shell, SWT.NONE);
		AddButton2.setTouchEnabled(true);
		AddButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[1]++;
				swcounter2.setText(String.valueOf(counter[1]));
				log.burger_menu.list.add(lblSand2.getText().concat("  £"+lblPrice2.getText()));
			}
		});
		AddButton2.setText("+");
		AddButton2.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton2.setBounds(327, 120, 20, 20);
		
		Button AddButton3 = new Button(shell, SWT.NONE);
		AddButton3.setTouchEnabled(true);
		AddButton3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[2]++;
				swcounter3.setText(String.valueOf(counter[2]));
				log.burger_menu.list.add(lblSand3.getText().concat("  £"+lblPrice3.getText()));
			}
		});
		AddButton3.setText("+");
		AddButton3.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton3.setBounds(327, 146, 20, 20);
		
		swcounter3 = new Text(shell, SWT.BORDER);
		swcounter3.setTouchEnabled(true);
		swcounter3.setText("0");
		swcounter3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		swcounter3.setBounds(286, 146, 35, 20);
		
		Button MinButton3 = new Button(shell, SWT.NONE);
		MinButton3.setTouchEnabled(true);
		MinButton3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[2]>0)
				{
					counter[2]--;
					swcounter3.setText(String.valueOf(counter[2]));
					log.burger_menu.list.remove(lblSand3.getText().concat("  £"+lblPrice3.getText()));
				}
			}
		});
		MinButton3.setText("-");
		MinButton3.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton3.setBounds(260, 146, 20, 20);
		
		Button MinButton4 = new Button(shell, SWT.NONE);
		MinButton4.setTouchEnabled(true);
		MinButton4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[3]>0)
				{
					counter[3]--;
					swcounter4.setText(String.valueOf(counter[3]));
					log.burger_menu.list.remove(lblSand4.getText().concat("  £"+lblPrice4.getText()));
				}
			}
		});
		MinButton4.setText("-");
		MinButton4.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton4.setBounds(260, 172, 20, 20);
		
		swcounter4 = new Text(shell, SWT.BORDER);
		swcounter4.setTouchEnabled(true);
		swcounter4.setText("0");
		swcounter4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		swcounter4.setBounds(286, 172, 35, 20);
		
		Button AddButton4 = new Button(shell, SWT.NONE);
		AddButton4.setTouchEnabled(true);
		AddButton4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[3]++;
				swcounter4.setText(String.valueOf(counter[3]));
				log.burger_menu.list.add(lblSand4.getText().concat("  £"+lblPrice4.getText()));
			}
		});
		AddButton4.setText("+");
		AddButton4.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton4.setBounds(327, 172, 20, 20);
		
		Button AddButton5 = new Button(shell, SWT.NONE);
		AddButton5.setTouchEnabled(true);
		AddButton5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[4]++;
				swcounter5.setText(String.valueOf(counter[4]));
				log.burger_menu.list.add(lblSand5.getText().concat("  £"+lblPrice5.getText()));
			}
		});
		AddButton5.setText("+");
		AddButton5.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton5.setBounds(327, 198, 20, 20);
		
		swcounter5 = new Text(shell, SWT.BORDER);
		swcounter5.setTouchEnabled(true);
		swcounter5.setText("0");
		swcounter5.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		swcounter5.setBounds(286, 198, 35, 20);
		
		Button MinButton5 = new Button(shell, SWT.NONE);
		MinButton5.setTouchEnabled(true);
		MinButton5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[4]>0)
				{
					counter[4]--;
					swcounter5.setText(String.valueOf(counter[4]));
					log.burger_menu.list.remove(lblSand5.getText().concat("  £"+lblPrice5.getText()));
				}
			}
		});
		MinButton5.setText("-");
		MinButton5.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton5.setBounds(260, 198, 20, 20);
		
		Button MinButton6 = new Button(shell, SWT.NONE);
		MinButton6.setTouchEnabled(true);
		MinButton6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[5]>0)
				{
					counter[5]--;
					swcounter6.setText(String.valueOf(counter[5]));
					log.burger_menu.list.remove(lblSand6.getText().concat("  £"+lblPrice6.getText()));
				}
			}
		});
		MinButton6.setText("-");
		MinButton6.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton6.setBounds(260, 224, 20, 20);
		
		swcounter6 = new Text(shell, SWT.BORDER);
		swcounter6.setTouchEnabled(true);
		swcounter6.setText("0");
		swcounter6.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		swcounter6.setBounds(286, 224, 35, 20);
		
		Button AddButton6 = new Button(shell, SWT.NONE);
		AddButton6.setTouchEnabled(true);
		AddButton6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[5]++;
				swcounter6.setText(String.valueOf(counter[5]));
				log.burger_menu.list.add(lblSand6.getText().concat("  £"+lblPrice6.getText()));
			}
		});
		AddButton6.setText("+");
		AddButton6.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton6.setBounds(327, 224, 20, 20);
		
		Button AddButton7 = new Button(shell, SWT.NONE);
		AddButton7.setTouchEnabled(true);
		AddButton7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[6]++;
				swcounter7.setText(String.valueOf(counter[6]));
				log.burger_menu.list.add(lblSand7.getText().concat("  £"+lblPrice7.getText()));
			}
		});
		AddButton7.setText("+");
		AddButton7.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton7.setBounds(327, 252, 20, 20);
		
		swcounter7 = new Text(shell, SWT.BORDER);
		swcounter7.setTouchEnabled(true);
		swcounter7.setText("0");
		swcounter7.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		swcounter7.setBounds(286, 252, 35, 20);
		
		Button Minbutton7 = new Button(shell, SWT.NONE);
		Minbutton7.setTouchEnabled(true);
		Minbutton7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[6]>0)
				{
					counter[6]--;
					swcounter7.setText(String.valueOf(counter[6]));
					log.burger_menu.list.remove(lblSand7.getText().concat("  £"+lblPrice7.getText()));
				}
			}
		});
		Minbutton7.setText("-");
		Minbutton7.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		Minbutton7.setBounds(260, 252, 20, 20);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setTouchEnabled(true);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setText("Cancel");
		btnCancel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnCancel.setBounds(110, 300, 75, 30);
		
		Button btnConfirm = new Button(shell, SWT.NONE);
		btnConfirm.setTouchEnabled(true);
		btnConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.confirm.open();
			}
		});
		btnConfirm.setText("Confirm");
		btnConfirm.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnConfirm.setBounds(250, 300, 75, 30);
		
		lblSand4 = new Label(shell, SWT.NONE);
		lblSand4.setTouchEnabled(true);
		lblSand4.setText("Chicken Sandwich");
		lblSand4.setAlignment(SWT.RIGHT);
		lblSand4.setBounds(75, 177, 110, 15);
		
		lblSand2 = new Label(shell, SWT.NONE);
		lblSand2.setTouchEnabled(true);
		lblSand2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSand2.setText("Tuna Sandwich");
		lblSand2.setAlignment(SWT.RIGHT);
		lblSand2.setBounds(75, 125, 110, 15);
		
		lblSand6 = new Label(shell, SWT.NONE);
		lblSand6.setTouchEnabled(true);
		lblSand6.setText("Salmon Sandwich");
		lblSand6.setAlignment(SWT.RIGHT);
		lblSand6.setBounds(75, 229, 110, 15);
		
		lblSand7 = new Label(shell, SWT.NONE);
		lblSand7.setTouchEnabled(true);
		lblSand7.setText("Beef BBQ Sandwich");
		lblSand7.setAlignment(SWT.RIGHT);
		lblSand7.setBounds(75, 257, 110, 15);
		
		lblSand5 = new Label(shell, SWT.NONE);
		lblSand5.setTouchEnabled(true);
		lblSand5.setText("Cheese Sandwich");
		lblSand5.setAlignment(SWT.RIGHT);
		lblSand5.setBounds(75, 203, 110, 15);
		
		lblSand3 = new Label(shell, SWT.NONE);
		lblSand3.setTouchEnabled(true);
		lblSand3.setText("Lamb Sandwich");
		lblSand3.setAlignment(SWT.RIGHT);
		lblSand3.setBounds(75, 151, 110, 15);
		
		lblSand1 = new Label(shell, SWT.NONE);
		lblSand1.setTouchEnabled(true);
		lblSand1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSand1.setText("Ham Sandwich");
		lblSand1.setAlignment(SWT.RIGHT);
		lblSand1.setBounds(75, 100, 110, 15);
		
		lblPrice2 = new Label(shell, SWT.NONE);
		lblPrice2.setTouchEnabled(true);
		lblPrice2.setText("2.99");
		lblPrice2.setBounds(204, 125, 50, 15);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setTouchEnabled(true);
		label_1.setText("\u00A3");
		label_1.setAlignment(SWT.RIGHT);
		label_1.setBounds(188, 100, 10, 15);
		
		lblPrice1 = new Label(shell, SWT.NONE);
		lblPrice1.setTouchEnabled(true);
		lblPrice1.setText("1.99");
		lblPrice1.setBounds(204, 100, 50, 15);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setTouchEnabled(true);
		label_3.setText("\u00A3");
		label_3.setAlignment(SWT.RIGHT);
		label_3.setBounds(188, 125, 10, 15);
		
		lblPrice3 = new Label(shell, SWT.NONE);
		lblPrice3.setTouchEnabled(true);
		lblPrice3.setText("4.49");
		lblPrice3.setBounds(204, 151, 50, 15);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setTouchEnabled(true);
		label_5.setText("\u00A3");
		label_5.setAlignment(SWT.RIGHT);
		label_5.setBounds(188, 151, 10, 15);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setTouchEnabled(true);
		label_6.setText("\u00A3");
		label_6.setAlignment(SWT.RIGHT);
		label_6.setBounds(188, 178, 10, 15);
		
		lblPrice4 = new Label(shell, SWT.NONE);
		lblPrice4.setTouchEnabled(true);
		lblPrice4.setText("3.99");
		lblPrice4.setBounds(204, 177, 50, 15);
		
		lblPrice5 = new Label(shell, SWT.NONE);
		lblPrice5.setTouchEnabled(true);
		lblPrice5.setText("1.99");
		lblPrice5.setBounds(204, 203, 50, 15);
		
		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setTouchEnabled(true);
		label_9.setText("\u00A3");
		label_9.setAlignment(SWT.RIGHT);
		label_9.setBounds(188, 203, 10, 15);
		
		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setTouchEnabled(true);
		label_10.setText("\u00A3");
		label_10.setAlignment(SWT.RIGHT);
		label_10.setBounds(188, 229, 10, 15);
		
		lblPrice6 = new Label(shell, SWT.NONE);
		lblPrice6.setTouchEnabled(true);
		lblPrice6.setText("4.99");
		lblPrice6.setBounds(204, 229, 50, 15);
		
		lblPrice7 = new Label(shell, SWT.NONE);
		lblPrice7.setTouchEnabled(true);
		lblPrice7.setText("4.99");
		lblPrice7.setBounds(204, 257, 50, 15);
		
		Label label_13 = new Label(shell, SWT.NONE);
		label_13.setTouchEnabled(true);
		label_13.setText("\u00A3");
		label_13.setAlignment(SWT.RIGHT);
		label_13.setBounds(188, 257, 10, 15);

	}
}
