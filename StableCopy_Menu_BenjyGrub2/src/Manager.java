import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Manager {

	protected Shell shell;
	protected String user = "admin";
	protected String password = "admin";
	private Text txtUser;
	private Text txtPass;
	LogScreen log;
	
	public Manager(LogScreen log )
	{
		this.log = log;
	}
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Manager window = new Manager(null);
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
		shell.setText("SWT Application");
		shell.setLocation(0,0);
		
		txtUser = new Text(shell, SWT.BORDER);
		txtUser.setTouchEnabled(true);
		txtUser.setBounds(126, 110, 221, 21);
		
		txtPass = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(e.keyCode== 13)
					{
						String logUser = txtUser.getText();
						String logPass= txtPass.getText();
						if(logPass.equals(password)&& logUser.equals(user))
						{
								shell.setVisible(false);
								log.item.open();
							
						}
						else {
							Component frame = new JFrame();
							JOptionPane.showMessageDialog(frame,
								    "Wrong user or password!" ,"Warning",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				catch(Exception ee)
				{
					
				}
				
			}
		});
		txtPass.setTouchEnabled(true);
		txtPass.setBounds(126, 149, 221, 21);
		
		Label lblThis = new Label(shell, SWT.NONE);
		lblThis.setTouchEnabled(true);
		lblThis.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblThis.setBounds(151, 25, 128, 25);
		lblThis.setText("Manager settings");
		
		Label lblUser = new Label(shell, SWT.NONE);
		lblUser.setTouchEnabled(true);
		lblUser.setAlignment(SWT.RIGHT);
		lblUser.setText("User:");
		lblUser.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblUser.setBounds(18, 109, 102, 25);
		
		Label lblPasswprd = new Label(shell, SWT.NONE);
		lblPasswprd.setTouchEnabled(true);
		lblPasswprd.setText("Password");
		lblPasswprd.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPasswprd.setAlignment(SWT.RIGHT);
		lblPasswprd.setBounds(18, 149, 102, 25);
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.setTouchEnabled(true);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				log.open();
			}
		});
		btnBack.setBounds(40, 209, 75, 25);
		btnBack.setText("Back");

		
	}
}
