import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
public class MainMenu {
	
	
	LogScreen log; // variable reference to SandwichMenu class
	List<String> list = new ArrayList<>(); // Instantiate a string list array
	public MainMenu(LogScreen log)
	{
		this.log = log;
	} 
	
	protected Shell shell; 
	int[] counter = {0,0,0,0,0,0,0}; // counter for each item press
	Text brgcounter1; Label lblBrg1;  Label txtbrgPrice1; float burgerPrice1;
	Text brgcounter2; Label lblBrg2;  Label txtbrgPrice2; float burgerPrice2;
	Text brgcounter3; Label lblBrg3;  Label txtbrgPrice3; float burgerPrice3;
	Text brgcounter4; Label lblBrg4;  Label txtbrgPrice4; float burgerPrice4;
	Text brgcounter5; Label lblBrg5;  Label txtbrgPrice5; float burgerPrice5;
	Text brgcounter6; Label lblBrg6;  Label txtbrgPrice6; float burgerPrice6;
	Text brgcounter7; Label lblBrg7;  Label txtbrgPrice7; float burgerPrice7;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainMenu window = new MainMenu(null);
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
			lblBrg1.setText(log.item.burgerName[0]);
			lblBrg2.setText(log.item.burgerName[1]);
			lblBrg3.setText(log.item.burgerName[2]);
			lblBrg4.setText(log.item.burgerName[3]);
			lblBrg5.setText(log.item.burgerName[4]);
			lblBrg6.setText(log.item.burgerName[5]);
			lblBrg7.setText(log.item.burgerName[6]);
			
			txtbrgPrice1.setText(log.item.burgerPrice[0]);
			txtbrgPrice2.setText(log.item.burgerPrice[1]);
			txtbrgPrice3.setText(log.item.burgerPrice[2]);
			txtbrgPrice4.setText(log.item.burgerPrice[3]);
			txtbrgPrice5.setText(log.item.burgerPrice[4]);
			txtbrgPrice6.setText(log.item.burgerPrice[5]);
			txtbrgPrice7.setText(log.item.burgerPrice[6]);
		}
		
		
			brgcounter1.setText(String.valueOf(counter[0]));
			brgcounter2.setText(String.valueOf(counter[1]));
			brgcounter3.setText(String.valueOf(counter[2]));
			brgcounter4.setText(String.valueOf(counter[3]));
			brgcounter5.setText(String.valueOf(counter[4]));
			brgcounter6.setText(String.valueOf(counter[5]));
			brgcounter7.setText(String.valueOf(counter[6]));
			
			
			burgerPrice1 = Float.parseFloat(txtbrgPrice1.getText());	
			burgerPrice2 = Float.parseFloat(txtbrgPrice2.getText());	
			burgerPrice3 = Float.parseFloat(txtbrgPrice3.getText());	
			burgerPrice4 = Float.parseFloat(txtbrgPrice4.getText());	
			burgerPrice5 = Float.parseFloat(txtbrgPrice5.getText());	
			burgerPrice6 = Float.parseFloat(txtbrgPrice6.getText());	
			burgerPrice7 = Float.parseFloat(txtbrgPrice7.getText());	
		
	
		
	}
	//calculate the total price for burger
	public float totalPriceBurger()
	{
		float burgerTotal=0;
		
		burgerTotal =(burgerPrice1 *(float)counter[0])+(burgerPrice2 *(float)counter[1])+(burgerPrice3 *(float)counter[2])+(burgerPrice4 *(float)counter[3])+(burgerPrice5*(float)counter[4])+(burgerPrice6 *(float)counter[5])+(burgerPrice7 *(float)counter[6]) ;
		return burgerTotal;
	}
	
	public float TotalPrice()
	{
		float total=0;
		float burg = totalPriceBurger();
		float sand = log.sandwich_menu.totalPriceSandwich();
		float dri = log.drink_menu.totalPriceDrink();
		total = burg + sand + dri;
		return total;
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
	
		shell = new Shell();
		shell.setTouchEnabled(true);
		shell.setMinimumSize(new Point(450, 400));
		shell.setSize(450, 400);
		shell.setText("Burger Menu");
		shell.setLocation(0,0);
		Button btnBurgers = new Button(shell, SWT.NONE);
		btnBurgers.setTouchEnabled(true);
		btnBurgers.setEnabled(false);
		btnBurgers.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnBurgers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnBurgers.setBounds(30, 30, 85, 40);
		btnBurgers.setText("Burgers");
		
		Button btnSandwiches = new Button(shell, SWT.NONE);
		btnSandwiches.setToolTipText("Go to Sandwich Menu");
		btnSandwiches.setTouchEnabled(true);
		btnSandwiches.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shell.setVisible(false);
				log.sandwich_menu.open();
			}
		});
		btnSandwiches.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnSandwiches.setBounds(155, 30, 115, 40);
		btnSandwiches.setText("Sandwiches");
		
		Button btnDrinks = new Button(shell, SWT.NONE);
		btnDrinks.setToolTipText("Go to Drinks Menu");
		btnDrinks.setTouchEnabled(true);
		btnDrinks.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.drink_menu.open();
			}
		});
		btnDrinks.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		btnDrinks.setBounds(310, 30, 85, 40);
		btnDrinks.setText("Drinks");
		
		Button Addbutton1 = new Button(shell, SWT.NONE);
		Addbutton1.setTouchEnabled(true);
		Addbutton1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[0]++;
				brgcounter1.setText(String.valueOf(counter[0]));
				list.add(lblBrg1.getText().concat("  £"+txtbrgPrice1.getText()));
				
			}
		});
		Addbutton1.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		Addbutton1.setBounds(327, 95, 20, 20);
		Addbutton1.setText("+");
		
		Button Addbutton2 = new Button(shell, SWT.NONE);
		Addbutton2.setTouchEnabled(true);
		Addbutton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[1]++;
				brgcounter2.setText(String.valueOf(counter[1]));
				list.add(lblBrg2.getText().concat("  £"+txtbrgPrice2.getText()));
			}
		});
		Addbutton2.setText("+");
		Addbutton2.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		Addbutton2.setBounds(327, 120, 20, 20);
		
		Button Addbutton3 = new Button(shell, SWT.NONE);
		Addbutton3.setTouchEnabled(true);
		Addbutton3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[2]++;
				brgcounter3.setText(String.valueOf(counter[2]));
				list.add(lblBrg3.getText().concat("  £"+txtbrgPrice3.getText()));
			}
		});
		Addbutton3.setText("+");
		Addbutton3.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		Addbutton3.setBounds(327, 146, 20, 20);
		
		Button Addbutton4 = new Button(shell, SWT.NONE);
		Addbutton4.setTouchEnabled(true);
		Addbutton4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[3]++;
				brgcounter4.setText(String.valueOf(counter[3]));
				list.add(lblBrg4.getText().concat("  £"+txtbrgPrice4.getText()));
			}
		});
		Addbutton4.setText("+");
		Addbutton4.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		Addbutton4.setBounds(327, 172, 20, 20);
		
		Button Addbutton5 = new Button(shell, SWT.NONE);
		Addbutton5.setTouchEnabled(true);
		Addbutton5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[4]++;
				brgcounter5.setText(String.valueOf(counter[4]));
				list.add(lblBrg5.getText().concat("  £"+txtbrgPrice5.getText()));
			}
		});
		Addbutton5.setText("+");
		Addbutton5.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		Addbutton5.setBounds(327, 198, 20, 20);
		
		Button Addbutton6 = new Button(shell, SWT.NONE);
		Addbutton6.setTouchEnabled(true);
		Addbutton6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[5]++;
				brgcounter6.setText(String.valueOf(counter[5]));
				list.add(lblBrg6.getText().concat("  £"+txtbrgPrice6.getText()));
			}
		});
		Addbutton6.setText("+");
		Addbutton6.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		Addbutton6.setBounds(327, 224, 20, 20);
		
		Button Addbutton7 = new Button(shell, SWT.NONE);
		Addbutton7.setTouchEnabled(true);
		Addbutton7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				counter[6]++;
				brgcounter7.setText(String.valueOf(counter[6]));
				list.add(lblBrg7.getText().concat("  £"+txtbrgPrice7.getText()));
			}
		});
		Addbutton7.setText("+");
		Addbutton7.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.BOLD));
		Addbutton7.setBounds(327, 252, 20, 20);
		
		Button Minbutton1 = new Button(shell, SWT.NONE);
		Minbutton1.setTouchEnabled(true);
		Minbutton1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[0]>0)
				{
					counter[0]--;
					brgcounter1.setText(String.valueOf(counter[0]));
					list.remove(lblBrg1.getText().concat("  £"+txtbrgPrice1.getText()));
				}
			}
		});
		Minbutton1.setText("-");
		Minbutton1.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		Minbutton1.setBounds(260, 95, 20, 20);
		
		Button Minbutton2 = new Button(shell, SWT.NONE);
		Minbutton2.setTouchEnabled(true);
		Minbutton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[1]>0)
				{
					counter[1]--;
					brgcounter2.setText(String.valueOf(counter[1]));
					list.remove(lblBrg2.getText().concat("  £"+txtbrgPrice2.getText()));
				}
			}
		});
		Minbutton2.setText("-");
		Minbutton2.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		Minbutton2.setBounds(260, 120, 20, 20);
		
		Button Minbutton3 = new Button(shell, SWT.NONE);
		Minbutton3.setTouchEnabled(true);
		Minbutton3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[2]>0)
				{
					counter[2]--;
					brgcounter3.setText(String.valueOf(counter[2]));
					list.remove(lblBrg3.getText().concat("  £"+txtbrgPrice3.getText()));
				}
			}
		});
		Minbutton3.setText("-");
		Minbutton3.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		Minbutton3.setBounds(260, 146, 20, 20);
		
		Button Minbutton4 = new Button(shell, SWT.NONE);
		Minbutton4.setTouchEnabled(true);
		Minbutton4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[3]>0)
				{
					counter[3]--;
					brgcounter4.setText(String.valueOf(counter[3]));
					list.remove(lblBrg4.getText().concat("  £"+txtbrgPrice4.getText()));
				}
			}
		});
		Minbutton4.setText("-");
		Minbutton4.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		Minbutton4.setBounds(260, 172, 20, 20);
		
		Button Minbutton5 = new Button(shell, SWT.NONE);
		Minbutton5.setTouchEnabled(true);
		Minbutton5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[4]>0)
				{
					counter[4]--;
					brgcounter5.setText(String.valueOf(counter[4]));
					list.remove(lblBrg5.getText().concat("  £"+txtbrgPrice5.getText()));
				}
			}
		});
		Minbutton5.setText("-");
		Minbutton5.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		Minbutton5.setBounds(260, 198, 20, 20);
		
		Button Minbutton6 = new Button(shell, SWT.NONE);
		Minbutton6.setTouchEnabled(true);
		Minbutton6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[5]>0)
				{
					counter[5]--;
					brgcounter6.setText(String.valueOf(counter[5]));
					list.remove(lblBrg6.getText().concat("  £"+txtbrgPrice6.getText()));
				}
			}
		});
		Minbutton6.setText("-");
		Minbutton6.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		Minbutton6.setBounds(260, 224, 20, 20);
		
		Button Minbutton7 = new Button(shell, SWT.NONE);
		Minbutton7.setTouchEnabled(true);
		Minbutton7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(counter[6]>0)
				{
					counter[6]--;
					brgcounter7.setText(String.valueOf(counter[6]));
					list.remove(lblBrg7.getText().concat("  £"+txtbrgPrice7.getText()));
				}
			}
		});
		Minbutton7.setText("-");
		Minbutton7.setFont(SWTResourceManager.getFont("Rockwell", 11, SWT.BOLD));
		Minbutton7.setBounds(260, 252, 20, 20);
		
		brgcounter1 = new Text(shell, SWT.BORDER);
		brgcounter1.setTouchEnabled(true);
		brgcounter1.setText("0\r\n");
		brgcounter1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		brgcounter1.setBounds(286, 95, 35, 20);
		
		brgcounter2 = new Text(shell, SWT.BORDER);
		brgcounter2.setTouchEnabled(true);
		brgcounter2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		brgcounter2.setText("0");
		brgcounter2.setBounds(286, 120, 35, 20);
		
		brgcounter3 = new Text(shell, SWT.BORDER);
		brgcounter3.setTouchEnabled(true);
		brgcounter3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		brgcounter3.setText("0");
		brgcounter3.setBounds(286, 146, 35, 20);
		
		brgcounter4 = new Text(shell, SWT.BORDER);
		brgcounter4.setTouchEnabled(true);
		brgcounter4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		brgcounter4.setText("0");
		brgcounter4.setBounds(286, 172, 35, 20);
		
		brgcounter5 = new Text(shell, SWT.BORDER);
		brgcounter5.setTouchEnabled(true);
		brgcounter5.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		brgcounter5.setText("0");
		brgcounter5.setBounds(286, 198, 35, 20);
		
		brgcounter6 = new Text(shell, SWT.BORDER);
		brgcounter6.setTouchEnabled(true);
		brgcounter6.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		brgcounter6.setText("0");
		brgcounter6.setBounds(286, 224, 35, 20);
		
		brgcounter7 = new Text(shell, SWT.BORDER);
		brgcounter7.setTouchEnabled(true);
		brgcounter7.setText("0");
		brgcounter7.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		brgcounter7.setBounds(286, 252, 35, 20);
		
		
		lblBrg1 = new Label(shell, SWT.NONE);
		lblBrg1.setTouchEnabled(true);
		lblBrg1.setAlignment(SWT.RIGHT);
		lblBrg1.setToolTipText("Beef Burger with Chips");
		lblBrg1.setBounds(30, 100, 150, 15);
		lblBrg1.setText("Beef Burger");
		
		lblBrg2 = new Label(shell, SWT.NONE);
		lblBrg2.setTouchEnabled(true);
		lblBrg2.setAlignment(SWT.RIGHT);
		lblBrg2.setToolTipText("Beef and Cheese Burger with Chips\r\n");
		lblBrg2.setBounds(30, 125, 150, 15);
		lblBrg2.setText("Cheese Burger");
		
		lblBrg4 = new Label(shell, SWT.NONE);
		lblBrg4.setTouchEnabled(true);
		lblBrg4.setAlignment(SWT.RIGHT);
		lblBrg4.setToolTipText("Double Beef Burger with Chips");
		lblBrg4.setText("Double Beef Burger");
		lblBrg4.setBounds(30, 177, 150, 15);
		
		lblBrg5 = new Label(shell, SWT.NONE);
		lblBrg5.setTouchEnabled(true);
		lblBrg5.setAlignment(SWT.RIGHT);
		lblBrg5.setToolTipText("Crispy Bacon and Beef with Chips\r\n");
		lblBrg5.setText("Bacon and Beef Burger");
		lblBrg5.setBounds(30, 203, 150, 15);
		
		lblBrg6 = new Label(shell, SWT.NONE);
		lblBrg6.setTouchEnabled(true);
		lblBrg6.setAlignment(SWT.RIGHT);
		lblBrg6.setToolTipText("Crispy Bacon and Beef Burger with Cheese and Chips ");
		lblBrg6.setText("Bacon and Cheese Burger");
		lblBrg6.setBounds(30, 227, 150, 15);
		
		lblBrg3 = new Label(shell, SWT.NONE);
		lblBrg3.setTouchEnabled(true);
		lblBrg3.setAlignment(SWT.RIGHT);
		lblBrg3.setToolTipText("Korean Style Chicken Burger with Coleslaw and Chips\r\n");
		lblBrg3.setText("Korean Burger");
		lblBrg3.setBounds(30, 151, 150, 15);
		
		lblBrg7 = new Label(shell, SWT.NONE);
		lblBrg7.setTouchEnabled(true);
		lblBrg7.setAlignment(SWT.RIGHT);
		lblBrg7.setToolTipText("Beef and White Mushroom Burger with Chips\r\n ");
		lblBrg7.setText("Beef and Mushroom Burger");
		lblBrg7.setBounds(30, 257, 150, 15);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setTouchEnabled(true);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnCancel.setBounds(110, 300, 75, 30);
		btnCancel.setText("Cancel");
		
		
		
		
		
		Button btnConfirm = new Button(shell, SWT.NONE);
		btnConfirm.setToolTipText("Confirm Order");
		btnConfirm.setTouchEnabled(true);
		btnConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { 
				shell.setVisible(false);
				
				log.confirm.open();
			}
		});
		btnConfirm.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnConfirm.setBounds(250, 300, 75, 30);
		btnConfirm.setText("Confirm");
		
		Label label_0 = new Label(shell, SWT.NONE);
		label_0.setTouchEnabled(true);
		label_0.setAlignment(SWT.RIGHT);
		label_0.setBounds(186, 100, 10, 15);
		label_0.setText("\u00A3");
		
		Label label = new Label(shell, SWT.NONE);
		label.setTouchEnabled(true);
		label.setText("\u00A3");
		label.setAlignment(SWT.RIGHT);
		label.setBounds(186, 125, 10, 15);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setTouchEnabled(true);
		label_1.setText("\u00A3");
		label_1.setAlignment(SWT.RIGHT);
		label_1.setBounds(186, 151, 10, 15);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setTouchEnabled(true);
		label_2.setText("\u00A3");
		label_2.setAlignment(SWT.RIGHT);
		label_2.setBounds(186, 229, 10, 15);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setTouchEnabled(true);
		label_3.setText("\u00A3");
		label_3.setAlignment(SWT.RIGHT);
		label_3.setBounds(186, 203, 10, 15);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setTouchEnabled(true);
		label_4.setText("\u00A3");
		label_4.setAlignment(SWT.RIGHT);
		label_4.setBounds(186, 178, 10, 15);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setTouchEnabled(true);
		label_5.setText("\u00A3");
		label_5.setAlignment(SWT.RIGHT);
		label_5.setBounds(186, 257, 10, 15);
		
		txtbrgPrice1 = new Label(shell, SWT.NONE);
		txtbrgPrice1.setTouchEnabled(true);
		txtbrgPrice1.setText("5.99");
		txtbrgPrice1.setBounds(202, 100, 50, 15);
		
		txtbrgPrice2 = new Label(shell, SWT.NONE);
		txtbrgPrice2.setTouchEnabled(true);
		txtbrgPrice2.setText("6.99");
		txtbrgPrice2.setBounds(202, 125, 50, 15);
		
		txtbrgPrice3 = new Label(shell, SWT.NONE);
		txtbrgPrice3.setTouchEnabled(true);
		txtbrgPrice3.setText("7.99");
		txtbrgPrice3.setBounds(202, 151, 50, 15);
		
		txtbrgPrice6 = new Label(shell, SWT.NONE);
		txtbrgPrice6.setTouchEnabled(true);
		txtbrgPrice6.setText("6.99");
		txtbrgPrice6.setBounds(202, 229, 50, 15);
		
		txtbrgPrice5 = new Label(shell, SWT.NONE);
		txtbrgPrice5.setTouchEnabled(true);
		txtbrgPrice5.setText("6.99");
		txtbrgPrice5.setBounds(202, 203, 50, 15);
		
		txtbrgPrice4 = new Label(shell, SWT.NONE);
		txtbrgPrice4.setTouchEnabled(true);
		txtbrgPrice4.setText("7.99");
		txtbrgPrice4.setBounds(202, 177, 50, 15);
		
		txtbrgPrice7 = new Label(shell, SWT.NONE);
		txtbrgPrice7.setTouchEnabled(true);
		txtbrgPrice7.setText("6.99");
		txtbrgPrice7.setBounds(202, 257, 50, 15);

	}
}
