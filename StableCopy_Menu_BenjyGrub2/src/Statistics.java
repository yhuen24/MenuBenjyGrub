import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Statistics {
	
	LogScreen log;
	// variable for item name
	Label lblBrg1;      Label lblSand1;       Label lblDri1;
	Label lblBrg2;      Label lblSand2;       Label lblDri2;
	Label lblBrg3;      Label lblSand3;       Label lblDri3;
	Label lblBrg4;      Label lblSand4;       Label lblDri4;
	Label lblBrg5;      Label lblSand5;       Label lblDri5;
	Label lblBrg6;      Label lblSand6;       Label lblDri6;
	Label lblBrg7;      Label lblSand7;
	// variable for item price
	Label lblBrgC1;     Label lblSandC1;      Label lblDriC1;
	Label lblBrgC2;     Label lblSandC2;      Label lblDriC2;
	Label lblBrgC3;     Label lblSandC3;      Label lblDriC3;
	Label lblBrgC4;     Label lblSandC4;      Label lblDriC4;
	Label lblBrgC5;     Label lblSandC5;      Label lblDriC5;
	Label lblBrgC6;     Label lblSandC6;      Label lblDriC6;
	Label lblBrgC7;     Label lblSandC7;
	
	int[] brgCounter = {0,0,0,0,0,0,0};
	int[] sandCounter = {0,0,0,0,0,0,0};
	int[] driCounter = {0,0,0,0,0,0};
	
	public Statistics (LogScreen log)
	{
		this.log = log;
	}

	protected Shell shlStatistics;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Statistics window = new Statistics(null);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void initialValue()
	{
			lblBrgC1.setText(String.valueOf(brgCounter[0]));   lblSandC1.setText(String.valueOf(sandCounter[0]));   lblDriC1.setText(String.valueOf(driCounter[0]));
			lblBrgC2.setText(String.valueOf(brgCounter[1]));   lblSandC2.setText(String.valueOf(sandCounter[1]));   lblDriC2.setText(String.valueOf(driCounter[1]));  
			lblBrgC3.setText(String.valueOf(brgCounter[2]));   lblSandC3.setText(String.valueOf(sandCounter[2]));   lblDriC3.setText(String.valueOf(driCounter[2]));
			lblBrgC4.setText(String.valueOf(brgCounter[3]));   lblSandC4.setText(String.valueOf(sandCounter[3]));   lblDriC4.setText(String.valueOf(driCounter[3]));
			lblBrgC5.setText(String.valueOf(brgCounter[4]));   lblSandC5.setText(String.valueOf(sandCounter[4]));   lblDriC5.setText(String.valueOf(driCounter[4]));
			lblBrgC6.setText(String.valueOf(brgCounter[5]));   lblSandC6.setText(String.valueOf(sandCounter[5]));   lblDriC6.setText(String.valueOf(driCounter[5]));
			lblBrgC7.setText(String.valueOf(brgCounter[6]));   lblSandC7.setText(String.valueOf(sandCounter[6]));

			lblBrg1.setText(log.item.burgerName[0]);   lblSand1.setText(log.item.sandwichName[0]);   lblDri1.setText(log.item.drinkName[0]);
			lblBrg2.setText(log.item.burgerName[1]);   lblSand2.setText(log.item.sandwichName[1]);   lblDri2.setText(log.item.drinkName[1]);
			lblBrg3.setText(log.item.burgerName[2]);   lblSand3.setText(log.item.sandwichName[2]);   lblDri3.setText(log.item.drinkName[2]);
			lblBrg4.setText(log.item.burgerName[3]);   lblSand4.setText(log.item.sandwichName[3]);   lblDri4.setText(log.item.drinkName[3]);
			lblBrg5.setText(log.item.burgerName[4]);   lblSand5.setText(log.item.sandwichName[4]);   lblDri5.setText(log.item.drinkName[4]);
			lblBrg6.setText(log.item.burgerName[5]);   lblSand6.setText(log.item.sandwichName[5]);   lblDri6.setText(log.item.drinkName[5]);
			lblBrg7.setText(log.item.burgerName[6]);   lblSand7.setText(log.item.sandwichName[6]);
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlStatistics.open();
		shlStatistics.layout();
		initialValue();
		while (!shlStatistics.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStatistics = new Shell();
		shlStatistics.setTouchEnabled(true);
		shlStatistics.setMinimumSize(new Point(680, 450));
		shlStatistics.setLocation(0, 0);
		shlStatistics.setSize(680, 450);
		shlStatistics.setText("Statistics");
		
		Label lblNumberOfItems = new Label(shlStatistics, SWT.NONE);
		lblNumberOfItems.setAlignment(SWT.CENTER);
		lblNumberOfItems.setFont(SWTResourceManager.getFont("Segoe UI", 17, SWT.ITALIC));
		lblNumberOfItems.setBounds(172, 10, 300, 30);
		lblNumberOfItems.setText("Number of items ordered");
		
		Button btnExit = new Button(shlStatistics, SWT.NONE);
		btnExit.setTouchEnabled(true);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setText("Exit");
		btnExit.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnExit.setBounds(295, 371, 75, 30);
		
		Label lblBurgers = new Label(shlStatistics, SWT.NONE);
		lblBurgers.setAlignment(SWT.CENTER);
		lblBurgers.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.ITALIC));
		lblBurgers.setBounds(57, 63, 80, 20);
		lblBurgers.setText("BURGERS");
		
		Label lblSandwich = new Label(shlStatistics, SWT.NONE);
		lblSandwich.setText("SANDWICH");
		lblSandwich.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.ITALIC));
		lblSandwich.setAlignment(SWT.CENTER);
		lblSandwich.setBounds(295, 63, 90, 20);
		
		Label lblDrinks = new Label(shlStatistics, SWT.NONE);
		lblDrinks.setText("DRINKS");
		lblDrinks.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.ITALIC));
		lblDrinks.setAlignment(SWT.CENTER);
		lblDrinks.setBounds(555, 63, 80, 20);
		
		lblBrg1 = new Label(shlStatistics, SWT.NONE);
		lblBrg1.setText("Beef Burger");
		lblBrg1.setBounds(58, 115, 150, 15);
		
		lblBrgC1 = new Label(shlStatistics, SWT.NONE);
		lblBrgC1.setAlignment(SWT.CENTER);
		lblBrgC1.setBounds(22, 115, 30, 15);
		lblBrgC1.setText("0");
		
		lblSandC1 = new Label(shlStatistics, SWT.NONE);
		lblSandC1.setText("0");
		lblSandC1.setAlignment(SWT.CENTER);
		lblSandC1.setBounds(268, 115, 30, 15);
		
		lblSand1 = new Label(shlStatistics, SWT.NONE);
		lblSand1.setText("Ham Sandwich");
		lblSand1.setBounds(304, 115, 150, 15);
		
		lblDriC1 = new Label(shlStatistics, SWT.NONE);
		lblDriC1.setText("0");
		lblDriC1.setAlignment(SWT.CENTER);
		lblDriC1.setBounds(536, 115, 30, 15);
		
		lblDri1 = new Label(shlStatistics, SWT.NONE);
		lblDri1.setText("Water");
		lblDri1.setBounds(572, 115, 100, 15);
		
		lblBrgC2 = new Label(shlStatistics, SWT.NONE);
		lblBrgC2.setText("0");
		lblBrgC2.setAlignment(SWT.CENTER);
		lblBrgC2.setBounds(22, 150, 30, 15);
		
		lblBrg2 = new Label(shlStatistics, SWT.NONE);
		lblBrg2.setText("Cheese Burger");
		lblBrg2.setBounds(57, 150, 150, 15);
		
		lblSandC2 = new Label(shlStatistics, SWT.NONE);
		lblSandC2.setText("0");
		lblSandC2.setAlignment(SWT.CENTER);
		lblSandC2.setBounds(268, 150, 30, 15);
		
		lblSand2 = new Label(shlStatistics, SWT.NONE);
		lblSand2.setText("Tuna Sandwich");
		lblSand2.setBounds(304, 150, 150, 15);
		
		lblDriC2 = new Label(shlStatistics, SWT.NONE);
		lblDriC2.setText("0");
		lblDriC2.setAlignment(SWT.CENTER);
		lblDriC2.setBounds(536, 150, 30, 15);
		
		lblDri2 = new Label(shlStatistics, SWT.NONE);
		lblDri2.setText("Fanta");
		lblDri2.setBounds(572, 150, 100, 15);
		
		lblBrgC3 = new Label(shlStatistics, SWT.NONE);
		lblBrgC3.setText("0");
		lblBrgC3.setAlignment(SWT.CENTER);
		lblBrgC3.setBounds(22, 185, 30, 15);
		
		lblBrg3 = new Label(shlStatistics, SWT.NONE);
		lblBrg3.setText("Korean Burger");
		lblBrg3.setBounds(58, 185, 150, 15);
		
		lblSandC3 = new Label(shlStatistics, SWT.NONE);
		lblSandC3.setText("0");
		lblSandC3.setAlignment(SWT.CENTER);
		lblSandC3.setBounds(268, 185, 30, 15);
		
		lblSand3 = new Label(shlStatistics, SWT.NONE);
		lblSand3.setText("Lamb Sandwich");
		lblSand3.setBounds(304, 185, 150, 15);
		
		lblDriC3 = new Label(shlStatistics, SWT.NONE);
		lblDriC3.setText("0");
		lblDriC3.setAlignment(SWT.CENTER);
		lblDriC3.setBounds(536, 185, 30, 15);
		
		lblDri3 = new Label(shlStatistics, SWT.NONE);
		lblDri3.setText("Sprite");
		lblDri3.setBounds(572, 185, 100, 15);
		
		lblBrgC4 = new Label(shlStatistics, SWT.NONE);
		lblBrgC4.setText("0");
		lblBrgC4.setAlignment(SWT.CENTER);
		lblBrgC4.setBounds(22, 220, 30, 15);
		
		lblBrg4 = new Label(shlStatistics, SWT.NONE);
		lblBrg4.setText("Double Beef Burger");
		lblBrg4.setBounds(58, 220, 150, 15);
		
		lblSandC4 = new Label(shlStatistics, SWT.NONE);
		lblSandC4.setText("0");
		lblSandC4.setAlignment(SWT.CENTER);
		lblSandC4.setBounds(268, 220, 30, 15);
		
		lblSand4 = new Label(shlStatistics, SWT.NONE);
		lblSand4.setText("Chicken Sandwich");
		lblSand4.setBounds(304, 220, 150, 15);
		
		lblDriC4 = new Label(shlStatistics, SWT.NONE);
		lblDriC4.setText("0");
		lblDriC4.setAlignment(SWT.CENTER);
		lblDriC4.setBounds(536, 220, 30, 15);
		
		lblDri4 = new Label(shlStatistics, SWT.NONE);
		lblDri4.setText("Apple Juice");
		lblDri4.setBounds(572, 220, 100, 15);
		
		lblBrgC5 = new Label(shlStatistics, SWT.NONE);
		lblBrgC5.setText("0");
		lblBrgC5.setAlignment(SWT.CENTER);
		lblBrgC5.setBounds(22, 255, 30, 15);
		
		lblBrg5 = new Label(shlStatistics, SWT.NONE);
		lblBrg5.setText("Bacon and Beef Burger");
		lblBrg5.setBounds(58, 255, 150, 15);
		
		lblSandC5 = new Label(shlStatistics, SWT.NONE);
		lblSandC5.setText("0");
		lblSandC5.setAlignment(SWT.CENTER);
		lblSandC5.setBounds(268, 255, 30, 15);
		
		lblSand5 = new Label(shlStatistics, SWT.NONE);
		lblSand5.setText("Cheese Sandwich");
		lblSand5.setBounds(304, 255, 150, 15);
		
		lblDriC5 = new Label(shlStatistics, SWT.NONE);
		lblDriC5.setText("0");
		lblDriC5.setAlignment(SWT.CENTER);
		lblDriC5.setBounds(536, 255, 30, 15);
		
		lblDri5 = new Label(shlStatistics, SWT.NONE);
		lblDri5.setText("Mango Juice");
		lblDri5.setBounds(572, 255, 100, 15);
		
		lblBrg6 = new Label(shlStatistics, SWT.NONE);
		lblBrg6.setText("Bacon and Cheese Burger");
		lblBrg6.setBounds(58, 290, 150, 15);
		
		lblBrgC6 = new Label(shlStatistics, SWT.NONE);
		lblBrgC6.setText("0");
		lblBrgC6.setAlignment(SWT.CENTER);
		lblBrgC6.setBounds(22, 290, 30, 15);
		
		lblSandC6 = new Label(shlStatistics, SWT.NONE);
		lblSandC6.setText("0");
		lblSandC6.setAlignment(SWT.CENTER);
		lblSandC6.setBounds(268, 290, 30, 15);
		
		lblSand6 = new Label(shlStatistics, SWT.NONE);
		lblSand6.setText("Salmon Sandwich");
		lblSand6.setBounds(304, 290, 150, 15);
		
		lblBrgC7 = new Label(shlStatistics, SWT.NONE);
		lblBrgC7.setText("0");
		lblBrgC7.setAlignment(SWT.CENTER);
		lblBrgC7.setBounds(22, 325, 30, 15);
		
		lblBrg7 = new Label(shlStatistics, SWT.NONE);
		lblBrg7.setText("Beef and Mushroom Burger");
		lblBrg7.setBounds(58, 325, 150, 15);
		
		lblSandC7 = new Label(shlStatistics, SWT.NONE);
		lblSandC7.setText("0");
		lblSandC7.setAlignment(SWT.CENTER);
		lblSandC7.setBounds(268, 325, 30, 15);
		
		lblSand7 = new Label(shlStatistics, SWT.NONE);
		lblSand7.setText("Beef BBQ Sandwich");
		lblSand7.setBounds(304, 325, 150, 15);
		
		lblDriC6 = new Label(shlStatistics, SWT.NONE);
		lblDriC6.setText("0");
		lblDriC6.setAlignment(SWT.CENTER);
		lblDriC6.setBounds(536, 290, 30, 15);
		
		lblDri6 = new Label(shlStatistics, SWT.NONE);
		lblDri6.setText("Orange Juice");
		lblDri6.setBounds(572, 290, 100, 15);

	}
}
