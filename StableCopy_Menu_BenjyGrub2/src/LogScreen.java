import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

public class LogScreen {

	MainMenu burger_menu;
	Confirm confirm;
	DrinksMenu drink_menu;
	ExitScreen exitScreen;
	ItemEditor item;
	Manager manager;
	Payment payment;
	SandwichMenu sandwich_menu;
	PaymentPrompt paymentPrompt;
	Statistics stats;
	boolean managerOpen = false;
	boolean mainOpen = false;
	boolean statsOpen=false;
	
	//
	public LogScreen()
	{
		this.burger_menu = new MainMenu(this);
		this.confirm = new Confirm(this);
		this.drink_menu = new DrinksMenu(this);
		this.exitScreen = new ExitScreen(this);
		this.item = new ItemEditor(this);
		this.manager = new Manager(this);
		this.payment = new Payment(this);
		this.sandwich_menu = new SandwichMenu(this);
		this.paymentPrompt = new PaymentPrompt(this);
		this.stats = new Statistics(this);
	}

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LogScreen window = new LogScreen();
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
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(450, 400));
		shell.setTouchEnabled(true);
		shell.setSize(450, 300);
		shell.setLocation(0,0);
		shell.setText("BenjyGrub Ordering System");
		
		Button btnOrder = new Button(shell, SWT.NONE);
		btnOrder.setTouchEnabled(true);
		btnOrder.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				mainOpen =true;
				burger_menu.open();
			}
		});
		btnOrder.setBounds(257, 209, 150, 40);
		btnOrder.setText("ORDER");
		
		Button btnManager = new Button(shell, SWT.ARROW | SWT.CENTER);
		btnManager.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				managerOpen = true;
				manager.open();
			}
		});
		btnManager.setAlignment(SWT.RIGHT);
		btnManager.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		btnManager.setTouchEnabled(true);
		btnManager.setImage(null);
		btnManager.setBounds(394, 321, 30, 30);
		
		Label lblWelcomeTo = new Label(shell, SWT.NONE);
		lblWelcomeTo.setTouchEnabled(true);
		lblWelcomeTo.setFont(SWTResourceManager.getFont("Segoe UI", 27, SWT.BOLD));
		lblWelcomeTo.setAlignment(SWT.CENTER);
		lblWelcomeTo.setBounds(10, 29, 281, 50);
		lblWelcomeTo.setText("Welcome to");
		
		Label lblBenjygrub = new Label(shell, SWT.NONE);
		lblBenjygrub.setTouchEnabled(true);
		lblBenjygrub.setText("BenjyGrub");
		lblBenjygrub.setFont(SWTResourceManager.getFont("Segoe UI", 27, SWT.BOLD));
		lblBenjygrub.setAlignment(SWT.CENTER);
		lblBenjygrub.setBounds(166, 85, 241, 57);
		
		Button btnExit = new Button(shell, SWT.NONE);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setTouchEnabled(true);
		btnExit.setText("Exit");
		btnExit.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnExit.setBounds(50, 209, 150, 40);

	}
}
