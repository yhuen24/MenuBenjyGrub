import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
//import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
public class DrinksMenu {

	LogScreen log;
	public DrinksMenu(LogScreen log)//Feeds MainMenu and SandwichMenu to any object that calls this
	{
		this.log = log;
	}
	
	
	 protected Shell shell;  
	 int counter[] = {0,0,0,0,0,0};
	 Text dcounter1; Label lblD1; Label lblPrice1; float drinkPrice1;
	 Text dcounter2; Label lblD2; Label lblPrice2; float drinkPrice2; 
	 Text dcounter3; Label lblD3; Label lblPrice3; float drinkPrice3;
	 Text dcounter4; Label lblD4; Label lblPrice4; float drinkPrice4; 
	 Text dcounter5; Label lblD5; Label lblPrice5; float drinkPrice5; 
	 Text dcounter6; Label lblD6; Label lblPrice6; float drinkPrice6; 

	/** 
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DrinksMenu window = new DrinksMenu(null);
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
				lblD1.setText(log.item.drinkName[0]);
				lblD2.setText(log.item.drinkName[1]);
				lblD3.setText(log.item.drinkName[2]);
				lblD4.setText(log.item.drinkName[3]);
				lblD5.setText(log.item.drinkName[4]);
				lblD6.setText(log.item.drinkName[5]);
				
				lblPrice1.setText(log.item.drinkPrice[0]);
				lblPrice2.setText(log.item.drinkPrice[1]);
				lblPrice3.setText(log.item.drinkPrice[2]);
				lblPrice4.setText(log.item.drinkPrice[3]);
				lblPrice5.setText(log.item.drinkPrice[4]);
				lblPrice6.setText(log.item.drinkPrice[5]);
			}
			dcounter1.setText(String.valueOf(counter[0]));
			dcounter2.setText(String.valueOf(counter[1]));
			dcounter3.setText(String.valueOf(counter[2]));
			dcounter4.setText(String.valueOf(counter[3]));
			dcounter5.setText(String.valueOf(counter[4]));
			dcounter6.setText(String.valueOf(counter[5]));
			
			drinkPrice1= Float.parseFloat(lblPrice1.getText());
			drinkPrice2= Float.parseFloat(lblPrice2.getText());
			drinkPrice3= Float.parseFloat(lblPrice3.getText());
			drinkPrice4= Float.parseFloat(lblPrice4.getText());
			drinkPrice5= Float.parseFloat(lblPrice5.getText());
			drinkPrice6= Float.parseFloat(lblPrice6.getText());
		}
		
		//calculate the total price for sandwiches
		public float totalPriceDrink()
		{
			float drinkTotal=0;
			drinkTotal =(drinkPrice1 *(float)counter[0])+(drinkPrice2 *(float)counter[1])+(drinkPrice3 *(float)counter[2])+(drinkPrice4 *(float)counter[3])+(drinkPrice5 *(float)counter[4])+(drinkPrice6 *(float)counter[5]);
			return drinkTotal;
		}


	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setTouchEnabled(true);
		shell.setMinimumSize(new Point(450, 400));
		shell.setSize(450, 300);
		shell.setText("Drinks Menu");
		shell.setLayout(null);
		shell.setLocation(0,0);
		
		Button btnBurgers = new Button(shell, SWT.NONE);
		btnBurgers.setTouchEnabled(true);
		btnBurgers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.burger_menu.open();
			}
		});
		btnBurgers.setText("Burgers");
		btnBurgers.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnBurgers.setBounds(32, 30, 85, 40);
		
		Button btnDrinks = new Button(shell, SWT.NONE);
		btnDrinks.setTouchEnabled(true);
		btnDrinks.setEnabled(false);
		btnDrinks.setText("Drinks");
		btnDrinks.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnDrinks.setBounds(312, 30, 85, 40);
		
		Button btnSandwiches = new Button(shell, SWT.NONE);
		btnSandwiches.setTouchEnabled(true);
		btnSandwiches.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.sandwich_menu.open();
			}
		});
		btnSandwiches.setText("Sandwiches");
		btnSandwiches.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnSandwiches.setBounds(157, 30, 115, 40);
		
		Button MinButton1 = new Button(shell, SWT.NONE);
		MinButton1.setTouchEnabled(true);
		MinButton1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[0]>0)
				{
					counter[0]--;
					dcounter1.setText(String.valueOf(counter[0]));
					log.burger_menu.list.remove(lblD1.getText().concat("  £"+lblPrice1.getText()));
				}
			}
		});
		MinButton1.setText("-");
		MinButton1.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton1.setBounds(227, 110, 20, 20);
		
		Button AddButton1 = new Button(shell, SWT.NONE);
		AddButton1.setTouchEnabled(true);
		AddButton1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[0]++;
				dcounter1.setText(String.valueOf(counter[0]));
				log.burger_menu.list.add(lblD1.getText().concat("  £"+lblPrice1.getText()));
			}
		});
		AddButton1.setText("+");
		AddButton1.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton1.setBounds(294, 110, 20, 20);
		
		Button MinButton2 = new Button(shell, SWT.NONE);
		MinButton2.setTouchEnabled(true);
		MinButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[1]>0)
				{
					counter[1]--;
					dcounter2.setText(String.valueOf(counter[1]));
					log.burger_menu.list.remove(lblD2.getText().concat("  £"+lblPrice2.getText()));
				}
			}
		});
		MinButton2.setText("-");
		MinButton2.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton2.setBounds(227, 135, 20, 20);
		
		Button AddButton2 = new Button(shell, SWT.NONE);
		AddButton2.setTouchEnabled(true);
		AddButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[1]++;
				dcounter2.setText(String.valueOf(counter[1]));
				log.burger_menu.list.add(lblD2.getText().concat("  £"+lblPrice2.getText()));
			}
		});
		AddButton2.setText("+");
		AddButton2.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton2.setBounds(294, 135, 20, 20);
		
		Button AddButton3 = new Button(shell, SWT.NONE);
		AddButton3.setTouchEnabled(true);
		AddButton3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[2]++;
				dcounter3.setText(String.valueOf(counter[2]));
				log.burger_menu.list.add(lblD3.getText().concat("  £"+lblPrice3.getText()));
			}
		});
		AddButton3.setText("+");
		AddButton3.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton3.setBounds(294, 161, 20, 20);
		
		Button MinButton3 = new Button(shell, SWT.NONE);
		MinButton3.setTouchEnabled(true);
		MinButton3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[2]>0)
				{
					counter[2]--;
					dcounter3.setText(String.valueOf(counter[2]));
					log.burger_menu.list.remove(lblD3.getText().concat("  £"+lblPrice3.getText()));
				}
			}
		});
		MinButton3.setText("-");
		MinButton3.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton3.setBounds(227, 161, 20, 20);
		
		Button MinButton4 = new Button(shell, SWT.NONE);
		MinButton4.setTouchEnabled(true);
		MinButton4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[3]>0)
				{
					counter[3]--;
					dcounter4.setText(String.valueOf(counter[3]));
					log.burger_menu.list.remove(lblD4.getText().concat("  £"+lblPrice4.getText()));
				}
			}
		});
		MinButton4.setText("-");
		MinButton4.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton4.setBounds(227, 187, 20, 20);
		
		Button AddButton4 = new Button(shell, SWT.NONE);
		AddButton4.setTouchEnabled(true);
		AddButton4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[3]++;
				dcounter4.setText(String.valueOf(counter[3]));
				log.burger_menu.list.add(lblD4.getText().concat("  £"+lblPrice4.getText()));
			}
		});
		AddButton4.setText("+");
		AddButton4.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton4.setBounds(294, 187, 20, 20);
		
		Button AddButton5 = new Button(shell, SWT.NONE);
		AddButton5.setTouchEnabled(true);
		AddButton5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[4]++;
				dcounter5.setText(String.valueOf(counter[4]));
				log.burger_menu.list.add(lblD5.getText().concat("  £"+lblPrice5.getText()));
			}
		});
		AddButton5.setText("+");
		AddButton5.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton5.setBounds(294, 213, 20, 20);
		
		Button MinButton5 = new Button(shell, SWT.NONE);
		MinButton5.setTouchEnabled(true);
		MinButton5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[4]>0)
				{
					counter[4]--;
					dcounter5.setText(String.valueOf(counter[4]));
					log.burger_menu.list.remove(lblD5.getText().concat("  £"+lblPrice5.getText()));
				}
			}
		});
		MinButton5.setText("-");
		MinButton5.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton5.setBounds(227, 213, 20, 20);
		
		Button MinButton6 = new Button(shell, SWT.NONE);
		MinButton6.setTouchEnabled(true);
		MinButton6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[5]>0)
				{
					counter[5]--;
					dcounter6.setText(String.valueOf(counter[5]));
					log.burger_menu.list.remove(lblD6.getText().concat("  £"+lblPrice6.getText()));
				}
			}
		});
		MinButton6.setText("-");
		MinButton6.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		MinButton6.setBounds(227, 239, 20, 20);
		
		Button AddButton6 = new Button(shell, SWT.NONE);
		AddButton6.setTouchEnabled(true);
		AddButton6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[5]++;
				dcounter6.setText(String.valueOf(counter[5]));
				log.burger_menu.list.add(lblD6.getText().concat("  £"+lblPrice6.getText()));
			}
		});
		AddButton6.setText("+");
		AddButton6.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		AddButton6.setBounds(294, 239, 20, 20);
		
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
		btnCancel.setBounds(112, 300, 75, 30);
		
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
		btnConfirm.setBounds(252, 300, 75, 30);
		
		lblD4 = new Label(shell, SWT.NONE);
		lblD4.setTouchEnabled(true);
		lblD4.setAlignment(SWT.RIGHT);
		lblD4.setText("Apple Juice");
		lblD4.setBounds(77, 187, 72, 15);
		
		lblD2 = new Label(shell, SWT.NONE);
		lblD2.setTouchEnabled(true);
		lblD2.setAlignment(SWT.RIGHT);
		lblD2.setText("Fanta");
		lblD2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblD2.setBounds(77, 135, 72, 15);
		
		lblD6 = new Label(shell, SWT.NONE);
		lblD6.setTouchEnabled(true);
		lblD6.setAlignment(SWT.RIGHT);
		lblD6.setText("Orange Juice");
		lblD6.setBounds(77, 239, 72, 15);
		
		lblD5 = new Label(shell, SWT.NONE);
		lblD5.setTouchEnabled(true);
		lblD5.setAlignment(SWT.RIGHT);
		lblD5.setText("Mango Juice");
		lblD5.setBounds(77, 213, 72, 15);
		
		lblD3 = new Label(shell, SWT.NONE);
		lblD3.setTouchEnabled(true);
		lblD3.setAlignment(SWT.RIGHT);
		lblD3.setText("Sprite");
		lblD3.setBounds(77, 161, 72, 15);
		
		lblD1 = new Label(shell, SWT.NONE);
		lblD1.setTouchEnabled(true);
		lblD1.setAlignment(SWT.RIGHT);
		lblD1.setText("Water");
		lblD1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblD1.setBounds(77, 110, 72, 15);
		
		dcounter1 = new Text(shell, SWT.BORDER);
		dcounter1.setTouchEnabled(true);
		dcounter1.setText("0");
		dcounter1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		dcounter1.setBounds(253, 108, 35, 20);
		
		dcounter2 = new Text(shell, SWT.BORDER);
		dcounter2.setTouchEnabled(true);
		dcounter2.setText("0");
		dcounter2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		dcounter2.setBounds(253, 135, 35, 20);
		
		dcounter3 = new Text(shell, SWT.BORDER);
		dcounter3.setTouchEnabled(true);
		dcounter3.setText("0");
		dcounter3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		dcounter3.setBounds(253, 161, 35, 20);
		
		dcounter4 = new Text(shell, SWT.BORDER);
		dcounter4.setTouchEnabled(true);
		dcounter4.setText("0");
		dcounter4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		dcounter4.setBounds(253, 187, 35, 20);
		
		dcounter5 = new Text(shell, SWT.BORDER);
		dcounter5.setTouchEnabled(true);
		dcounter5.setText("0");
		dcounter5.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		dcounter5.setBounds(253, 213, 35, 20);
		
		dcounter6 = new Text(shell, SWT.BORDER);
		dcounter6.setTouchEnabled(true);
		dcounter6.setText("0");
		dcounter6.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		dcounter6.setBounds(253, 239, 35, 20);
		
		Label label = new Label(shell, SWT.NONE);
		label.setTouchEnabled(true);
		label.setText("\u00A3");
		label.setAlignment(SWT.RIGHT);
		label.setBounds(155, 110, 10, 15);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setTouchEnabled(true);
		label_1.setText("\u00A3");
		label_1.setAlignment(SWT.RIGHT);
		label_1.setBounds(155, 135, 10, 15);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setTouchEnabled(true);
		label_2.setText("\u00A3");
		label_2.setAlignment(SWT.RIGHT);
		label_2.setBounds(155, 161, 10, 15);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setTouchEnabled(true);
		label_3.setText("\u00A3");
		label_3.setAlignment(SWT.RIGHT);
		label_3.setBounds(155, 239, 10, 15);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setTouchEnabled(true);
		label_4.setText("\u00A3");
		label_4.setAlignment(SWT.RIGHT);
		label_4.setBounds(155, 213, 10, 15);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setTouchEnabled(true);
		label_5.setText("\u00A3");
		label_5.setAlignment(SWT.RIGHT);
		label_5.setBounds(155, 188, 10, 15);
		
		lblPrice1 = new Label(shell, SWT.NONE);
		lblPrice1.setTouchEnabled(true);
		lblPrice1.setText("0.75");
		lblPrice1.setBounds(171, 110, 50, 15);
		
		lblPrice2 = new Label(shell, SWT.NONE);
		lblPrice2.setTouchEnabled(true);
		lblPrice2.setText("0.99");
		lblPrice2.setBounds(171, 135, 50, 15);
		
		lblPrice3 = new Label(shell, SWT.NONE);
		lblPrice3.setTouchEnabled(true);
		lblPrice3.setText("0.99");
		lblPrice3.setBounds(171, 161, 50, 15);
		
		lblPrice4 = new Label(shell, SWT.NONE);
		lblPrice4.setTouchEnabled(true);
		lblPrice4.setText("1.49");
		lblPrice4.setBounds(171, 187, 50, 15);
		
		lblPrice5 = new Label(shell, SWT.NONE);
		lblPrice5.setTouchEnabled(true);
		lblPrice5.setText("1.49");
		lblPrice5.setBounds(171, 213, 50, 15);
		
		lblPrice6 = new Label(shell, SWT.NONE);
		lblPrice6.setTouchEnabled(true);
		lblPrice6.setText("1.49");
		lblPrice6.setBounds(171, 239, 50, 15);

	}
}
