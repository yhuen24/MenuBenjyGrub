import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import java.text.DecimalFormat;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
public class Payment {

	
	LogScreen log;
	public static DecimalFormat df = new DecimalFormat("0.00");
	String price;
	String cashola;
	float totalP;
	float change=0f;
	float pera=0f;
	String finalChange;
	public Payment(LogScreen log)
	{
		this.log = log;
	}
	
	
	protected Shell shell;
	private Text cash;

	/**
	 * Launch the application.
	 * @param args
	 */
	
	public static void main(String[] args) {
		try {
			Payment window = new Payment(null);
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
		shell.setMinimumSize(new Point(450, 400));
		shell.setSize(450, 300);
		shell.setText("Payment Via Cash");
		shell.setLocation(0,0);
		Button btnPay = new Button(shell, SWT.NONE);
		btnPay.setTouchEnabled(true);
		btnPay.setEnabled(false);
		btnPay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.exitScreen.open();
			}
		});
		btnPay.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnPay.setBounds(170, 270, 85, 30);
		btnPay.setText("Exit");
		
		Label lblTotalPrice = new Label(shell, SWT.NONE);
		lblTotalPrice.setTouchEnabled(true);
		lblTotalPrice.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblTotalPrice.setBounds(127, 70, 85, 20);
		lblTotalPrice.setText("Total Price: \u00A3");
		
		Label lblPrice = new Label(shell, SWT.NONE);
		lblPrice.setTouchEnabled(true);
		lblPrice.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPrice.setBounds(218, 70, 85, 20);
		lblPrice.setText("0.00");
		
		cash = new Text(shell, SWT.BORDER);
		cash.setTouchEnabled(true);
		cash.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		
		cash.setText("0");
		cash.setBounds(229, 150, 157, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setTouchEnabled(true);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel.setBounds(42, 150, 181, 20);
		lblNewLabel.setText("Enter your payment here:  \u00A3");
		price = df.format(log.burger_menu.TotalPrice());
		totalP = Float.parseFloat(price);
    	lblPrice.setText(price);
    	
    	Label lblChange = new Label(shell, SWT.NONE);
    	lblChange.setTouchEnabled(true);
    	lblChange.setText("Change:  \u00A3");
    	lblChange.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
    	lblChange.setBounds(42, 199, 69, 20);
    	
    	Label lblFinalChange = new Label(shell, SWT.NONE);
    	lblFinalChange.setTouchEnabled(true);
    	lblFinalChange.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
    	lblFinalChange.setBounds(117, 199, 269, 20);
  
    	
    	cash.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(e.keyCode== 13)
					{
						cashola = cash.getText();
						pera = Float.parseFloat(cashola);
						change = pera - totalP;
						finalChange = df.format(change);
						if(change<0)
						{
							lblChange.setText("Balance: £");
							lblFinalChange.setText(finalChange);
							btnPay.setEnabled(false);
							shell.setVisible(false);
							log.paymentPrompt.open();
						}
						else
						{
							btnPay.setEnabled(true);
							lblChange.setText("Change: £");
							lblFinalChange.setText(finalChange);
						}
					}
				}
				catch(Exception ee)
				{
					lblChange.setText("       Error: ");
					lblFinalChange.setText("Please input a valid payment !");
					btnPay.setEnabled(false);
				}
			}
			
		});
    	
	}
}
