import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class ExitScreen {
	
	
	LogScreen log;
	public ExitScreen(LogScreen log)
	{
		this.log=log;
	}

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ExitScreen window = new ExitScreen(null);
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
		shell.setTouchEnabled(true);
		shell.setSize(450, 300);
		shell.setText("Process Screen");
		shell.setLocation(0,0);
		
		Label lblThankYou = new Label(shell, SWT.NONE);
		lblThankYou.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblThankYou.setTouchEnabled(true);
		lblThankYou.setAlignment(SWT.CENTER);
		lblThankYou.setBounds(163, 99, 105, 20);
		lblThankYou.setText("THANK YOU");
		
		Button btnExit = new Button(shell, SWT.NONE);
		btnExit.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnExit.setTouchEnabled(true);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(299, 190, 75, 30);
		btnExit.setText("Exit");
		
		Label lblProcessComplete = new Label(shell, SWT.NONE);
		lblProcessComplete.setTouchEnabled(true);
		lblProcessComplete.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblProcessComplete.setText("Process Complete");
		lblProcessComplete.setAlignment(SWT.CENTER);
		lblProcessComplete.setBounds(122, 55, 188, 20);
		
		Button btnOrderAgain = new Button(shell, SWT.NONE);
		btnOrderAgain.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addCounter();
				resetValue();
				shell.setVisible(false);
				log.open();
			}
		});
		btnOrderAgain.setTouchEnabled(true);
		btnOrderAgain.setText("Order Again");
		btnOrderAgain.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnOrderAgain.setBounds(58, 190, 100, 30);

	}
	
	public void addCounter()
	{
		for(int i=0;i<log.burger_menu.counter.length;i++)
		{
			log.stats.brgCounter[i] += log.burger_menu.counter[i];
			log.stats.sandCounter[i] += log.sandwich_menu.counter[i];
		}
		for(int j=0;j<log.drink_menu.counter.length;j++)
		{
			log.stats.driCounter[j] += log.drink_menu.counter[j];
		}
	}
	
	public void resetValue()
	{
		for(int i = 0;i<log.burger_menu.counter.length;i++)
		{
			log.burger_menu.counter[i] = 0;
			log.sandwich_menu.counter[i] = 0;
		}
		for(int j=0;j<log.drink_menu.counter.length;j++)
		{
			log.drink_menu.counter[j] = 0;
		}
		log.burger_menu.list.clear();
		log.mainOpen = false;
		log.managerOpen = true;
		log.statsOpen = false;
	}
		
}
