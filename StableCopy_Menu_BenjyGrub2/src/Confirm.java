import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Label;
import java.text.DecimalFormat;
public class Confirm {

	LogScreen log;
	boolean isCash = true;
	String price;
	public static DecimalFormat df = new DecimalFormat("0.00");
	public Confirm(LogScreen log)
	{
		this.log = log;
	}
	
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Confirm window = new Confirm(null);
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
		shell.setTouchEnabled(true);
		shell.setMinimumSize(new Point(450, 400));
		shell.setSize(450, 300);
		shell.setText("Payment Form");
		shell.setLocation(0,0);
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.setTouchEnabled(true);
		btnBack.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				log.burger_menu.open();
			}
		});
		btnBack.setBounds(112, 300, 80, 30);
		btnBack.setText("Back");
		
		ListViewer listViewer = new ListViewer(shell, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.setTouchEnabled(true);
		list.setBounds(20, 33, 390, 200);
		
		Label lblMeal = new Label(shell, SWT.NONE);
		lblMeal.setTouchEnabled(true);
		lblMeal.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblMeal.setBounds(20, 10, 100, 20);
		lblMeal.setText("Your Order :");
		
		Label lblPayBy = new Label(shell, SWT.NONE);
		lblPayBy.setTouchEnabled(true);
		lblPayBy.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblPayBy.setBounds(225, 240, 55, 20);
		lblPayBy.setText("Pay by :");
		
		Button btnCard = new Button(shell, SWT.RADIO);
		btnCard.setTouchEnabled(true);
		btnCard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				isCash = false;
			}
		});
		btnCard.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnCard.setBounds(293, 240, 50, 20);
		btnCard.setText("Card");
		
		Button btnCash = new Button(shell, SWT.RADIO);
		btnCash.setTouchEnabled(true);
		btnCash.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				isCash= true;	
			}
		});
		btnCash.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnCash.setBounds(360, 240, 50, 20);
		btnCash.setText("Cash");
		
		Button btnPay = new Button(shell, SWT.NONE);
		btnPay.setTouchEnabled(true);
		
		btnPay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				if(isCash)
				{
					log.payment.open();
				}
				else
				{
					log.exitScreen.open();
				}
				
			}
		});
		btnPay.setText("Pay");
		btnPay.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnPay.setBounds(250, 300, 80, 30);
		
		Label lbl_Total = new Label(shell, SWT.NONE);
		lbl_Total.setTouchEnabled(true);
		lbl_Total.setText("Total : \u00A3");
		lbl_Total.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lbl_Total.setBounds(20, 240, 50, 20);
		
		Label lblTotal = new Label(shell, SWT.NONE);
		lblTotal.setTouchEnabled(true);
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTotal.setBounds(76, 240, 55, 20);
		
		for(String str : log.burger_menu.list)
		{
			list.add(str);
		}
		price = df.format(log.burger_menu.TotalPrice());
		lblTotal.setText(price);
		
	}
}
