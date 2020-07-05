import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.text.DecimalFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PaymentPrompt {
	
	
	LogScreen log;
	Label lblBalance;
	Label lblBal;
	Label lblPro;
	String preCash;
	String preFinalChange;
	Button btnConfirm;
	float addCash=0f;
	float preChange = 0f;
	public static DecimalFormat df = new DecimalFormat("0.00");
	public PaymentPrompt(LogScreen log)
	{
		this.log = log;
	}

	protected Shell shell;
	private Text txtAdd;
	private Button btnPayBalanceBy;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PaymentPrompt window = new PaymentPrompt(null);
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
		shell.setMinimumSize(new Point(140, 40));
		shell.setSize(450, 300);
		shell.setText("Warning");
		shell.setLocation(0,0);
		
		txtAdd = new Text(shell, SWT.BORDER);
		txtAdd.setTouchEnabled(true);
		txtAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(e.keyCode== 13)
					{
						preCash = txtAdd.getText();
						addCash= Float.parseFloat(preCash);
						preChange = log.payment.change;
						preChange = preChange + addCash;
						preFinalChange = df.format(preChange);
						if(preChange<0)
						{
							lblBalance.setText(preFinalChange);
						}
						else
						{
							btnConfirm.setEnabled(true);
							lblBal.setText("Change:  £");
							lblBalance.setText(preFinalChange);
						}
					}
				}
				catch(Exception ee)
				{
					lblPro.setText("Please input valid payment!");
				}
			}
		});
		txtAdd.setBounds(159, 114, 151, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setTouchEnabled(true);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel.setBounds(27, 114, 126, 20);
		lblNewLabel.setText("Add  payment      \u00A3");
		
		lblPro = new Label(shell, SWT.NONE);
		lblPro.setTouchEnabled(true);
		lblPro.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblPro.setBounds(27, 10, 169, 20);
		lblPro.setText("You paid insufficent amount !");
		
		lblBal = new Label(shell, SWT.NONE);
		lblBal.setTouchEnabled(true);
		lblBal.setText("Balance:    \u00A3");
		lblBal.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblBal.setBounds(27, 39, 75, 20);
		
		lblBalance = new Label(shell, SWT.NONE);
		lblBalance.setTouchEnabled(true);
		lblBalance.setText("0");
		lblBalance.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblBalance.setBounds(108, 39, 220, 20);
		lblBalance.setText(log.payment.finalChange);
		
		btnConfirm = new Button(shell, SWT.NONE);
		btnConfirm.setTouchEnabled(true);
		btnConfirm.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnConfirm.setEnabled(false);
		btnConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.exitScreen.open();
			}
		});
		btnConfirm.setBounds(324, 209, 75, 30);
		btnConfirm.setText("Confirm");
		
		btnPayBalanceBy = new Button(shell, SWT.NONE);
		btnPayBalanceBy.setTouchEnabled(true);
		btnPayBalanceBy.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnPayBalanceBy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.exitScreen.open();
			}
		});
		btnPayBalanceBy.setText("Pay balance by card");
		btnPayBalanceBy.setBounds(27, 209, 134, 30);

	}
}
