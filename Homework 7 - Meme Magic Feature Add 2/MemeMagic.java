import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * MemeMagic Graphical User Interface 
 * 
 * This class contains the graphical user interface for the Meme Magic Software
 * 
 * You will need to implement certain portions of this class, marked with comments starting with "TODO" to connect 
 * it with your existing code. 
 * 
 * This class provides an example layout for the GUI. You are encouraged to be creative in your design. 
 * More information about Swing is online at: 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html.
 */
public class MemeMagic extends JFrame 
{

    private static final long serialVersionUID = 1L;
    
    private User user;
    private GraphicalMeme currentMeme;
    private String backgroundImageFilename;
    private BorderLayout panelLayout;
    private JLabel backgroundImageFileNameLabel;
    private JLabel imageDisplayLabel;
    private JPanel controlPanel;
    private JPanel memeViewPanel;
    private JPanel panelPane;

	//Title (for BackgroundImage Panel)
    private JPanel backgroundImageTitlePanel;
    private JLabel backgroundImageTitleLabel;
    private JTextField backgroundImageTitleTextField;
    //Description (for BackgroundImage Panel)
    private JPanel backgroundImageDescriptionPanel;
    private JLabel backgroundImageDescriptionLabel;
    private JTextField backgroundImageDescriptionTextField;
    
    //Meme Panel
    private JPanel memePanel;
    //Caption (for Meme Panel)
    private JPanel memeCaptionPanel;
    private JLabel memeCaptionLabel;
    private JTextField memeCaptionTextField;
    //Vertical Align (for Meme Panel)
    private JPanel memeVerticalAlignPanel;
    private JLabel memeVerticalAlignLabel;
    private JComboBox<String> memeVerticalAlignComboBox;
    private String[] memeVerticalAlignStrings = {"top", "middle", "bottom"};
    
    //Generate and Save Buttons
    private JPanel generateAndSavePanel;
    private JButton generateButton;
    private JButton saveButton;
    
    public MemeMagic() 
    {
        this.user = new User();
    }
    
    public MemeMagic(User user) 
    {
        this.user = user;
    }


    /**
     * Main method.  This method initializes a PhotoViewer, loads images into a PhotographContainer, then
     * initializes the Graphical User Interface.
     * 
     * @param args  Optional command-line arguments
     */
    public static void main(String[] args) 
    {
        
        // Create a User object for this instance of Meme Magic
        User user = new User();

        // Instantiate the PhotoViewer Class
        MemeMagic myViewer = new MemeMagic(user);
        
        // Invoke and start the Graphical User Interface
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.initialize());
    }

    /**
     * Initialize all the GUI components.  This method will be called by
     * SwingUtilities when the application is started.
     */
    private void initialize() 
    {

        // Tell Java to exit the program when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tell Java to title the window to Meme Magic
        this.setTitle("Meme Magic");
        // We will use border layout on the main panel, since it is much easier for organizing panels.
        panelLayout = new BorderLayout();
        panelPane = new JPanel(panelLayout);
        // Create a label to display the full image.
        imageDisplayLabel = new JLabel();
        imageDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
        imageDisplayLabel.setPreferredSize(new Dimension(550, 550));
        // Create a panel on which to display the full image
        memeViewPanel = new JPanel(new BorderLayout());
        memeViewPanel.setPreferredSize(new Dimension(550, 550));
        memeViewPanel.add(imageDisplayLabel, BorderLayout.CENTER);
        // Create a panel on which to display the controls for building a Meme
        controlPanel = new JPanel(new BorderLayout());      
        // Create a panel that holds BackgroundImage information and give it a title
        JPanel backgroundImagePanel = new JPanel(new BorderLayout());
        backgroundImagePanel.setBorder(BorderFactory.createTitledBorder("Background Image"));
        // Create a panel that provides input for the BackgroundImage fileName
        JPanel backgroundImageFilePanel = new JPanel();  
        // Label
        JLabel backgroundImageFileLabel = new JLabel("Filename: ");
        backgroundImageFileLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageFilePanel.add(backgroundImageFileLabel);                       
        // Button
        JButton backgroundImageButton = new JButton("Browse");
        backgroundImageFilePanel.add(backgroundImageButton);
        backgroundImageButton.setPreferredSize(new Dimension(85, 20));
        
        // TODO The button needs a listener
        backgroundImageButton.addActionListener(new OpenButtonListener()); 
        
        // Label that will contain the filename of the image
        backgroundImageFileNameLabel = new JLabel("<choose>");
        backgroundImageFilePanel.add(backgroundImageFileNameLabel);
        backgroundImageFileNameLabel.setPreferredSize(new Dimension(265, 20));    
        // Add the panel about the BackgroundImage fileName to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageFilePanel, BorderLayout.NORTH);
        
        //TODO Complete the Control Panel implementation (with Background Image and Meme panels)
        
        //Title Components (for BackgroundImage Panel)
        backgroundImageTitlePanel = new JPanel();
        backgroundImageTitleLabel = new JLabel("Title: ");
        backgroundImageTitleLabel.setPreferredSize(new Dimension(99, 25)); 
        backgroundImageTitleTextField = new JTextField(29);
        //Add Title Components to BackgroundImage Title Panel
        backgroundImageTitlePanel.add(backgroundImageTitleLabel);
        backgroundImageTitlePanel.add(backgroundImageTitleTextField);
        //Add BackgroundImage Title Panel to BackgroundImage Panel
        backgroundImagePanel.add(backgroundImageTitlePanel, BorderLayout.CENTER ); 
        
        //Description Components (for BackgroundImage Panel)
        backgroundImageDescriptionPanel = new JPanel(); 
        backgroundImageDescriptionLabel = new JLabel("Description: "); 
        backgroundImageDescriptionLabel.setPreferredSize(new Dimension(99, 25)); 
        backgroundImageDescriptionTextField = new JTextField(29);
        //Add Description Components to BackgroundImage Description Panel
        backgroundImageDescriptionPanel.add(backgroundImageDescriptionLabel); 
        backgroundImageDescriptionPanel.add(backgroundImageDescriptionTextField); 
        //Add BackgroundImage Description Panel to BackgroundImage Panel
        backgroundImagePanel.add(backgroundImageDescriptionPanel, BorderLayout.SOUTH); 
        
        //Meme JPanel
        memePanel = new JPanel(new BorderLayout()); 
        memePanel.setBorder(BorderFactory.createTitledBorder("Meme"));
        //Caption Components
        memeCaptionPanel = new JPanel(); 
        memeCaptionLabel = new JLabel("Caption: "); 
        memeCaptionLabel.setPreferredSize(new Dimension(99, 25)); 
        memeCaptionTextField = new JTextField(29);
        memeCaptionPanel.add(memeCaptionLabel);
        memeCaptionPanel.add(memeCaptionTextField);
        //Add Caption Panel to Meme Panel
        memePanel.add(memeCaptionPanel, BorderLayout.NORTH);
        
        //Vertical Align Components
        memeVerticalAlignPanel = new JPanel(); 
        memeVerticalAlignLabel = new JLabel("Vertical Align: "); 
        memeVerticalAlignLabel.setPreferredSize(new Dimension(95, 25));  
        memeVerticalAlignComboBox = new JComboBox<String>(memeVerticalAlignStrings);
        memeVerticalAlignComboBox.setPreferredSize(new Dimension(360, 25));
        memeVerticalAlignComboBox.setMaximumSize(memeVerticalAlignComboBox.getPreferredSize());
        //Add Vertical Align Components to memeVerticalAlignPanel
        memeVerticalAlignPanel.add(memeVerticalAlignLabel, BorderLayout.WEST); 
        memeVerticalAlignPanel.add(memeVerticalAlignComboBox);
        //Add Vertical Align Panel to Meme Panel
        memePanel.add(memeVerticalAlignPanel); 
        //Add Meme Panel to Control Panel
        controlPanel.add(memePanel, BorderLayout.CENTER);
        
        // Add the BackgroundImage information panel to the control panel
        controlPanel.add(backgroundImagePanel, BorderLayout.NORTH);
        // Add all the panels to the main display based on BorderLayout
        controlPanel.setPreferredSize(new Dimension(500,570));
        panelPane.add(controlPanel, BorderLayout.WEST);
        panelPane.add(memeViewPanel, BorderLayout.CENTER);
        // Add the panelPane to the contentPane of the Frame (Window)
        this.getContentPane().add(panelPane);
        // Set the preferred size and show the main application window
        this.setPreferredSize(new Dimension(1150, 570));
        this.pack();
        this.setVisible(true);
        
        //Panel for Generate and Save Buttons
        generateAndSavePanel = new JPanel(new BorderLayout());
        controlPanel.add(generateAndSavePanel, BorderLayout.SOUTH);
        
        //Generate Button
        generateButton = new JButton("Generate");
        generateButton.setPreferredSize(new Dimension(85, 30));
        generateButton.addActionListener(new GenerateButtonListener());
        generateAndSavePanel.add(generateButton, BorderLayout.WEST);
        //Save Button
        saveButton = new JButton("Save");
        saveButton.setPreferredSize(new Dimension(75, 30));
        generateAndSavePanel.add(saveButton, BorderLayout.EAST);
        saveButton.addActionListener(new SaveButtonListener());
        
        
        
    }
    private class GenerateButtonListener implements ActionListener
    {
    	/**
    	 * Implements the actionPerformed Operations. 
    	 * Calls the getText Method using the 
    	 */
    	public void actionPerformed(ActionEvent event)
    	{
    		String caption = memeCaptionTextField.getText();
    		String title = backgroundImageTitleTextField.getText();
    		String description = backgroundImageDescriptionTextField.getText();
    		String imageFileName = backgroundImageFileNameLabel.getText();
    		String captionVeritcalAlign = (String) memeVerticalAlignComboBox.getSelectedItem();
    		BackgroundImage image = new BackgroundImage(imageFileName, title, description);
    		currentMeme = new GraphicalMeme(image, caption, user);
    		currentMeme.setCaptionVerticalAlign(captionVeritcalAlign);
    		try
    		{
    			BufferedImage bufferedImage = currentMeme.compileMeme();
    			imageDisplayLabel.setIcon(new javax.swing.ImageIcon(bufferedImage));
    			memeViewPanel.repaint();
    		}
    		catch(IOException exception)
    		{
    			System.err.println(exception.toString());
    		}
    		catch(Exception exception)
    		{
    			System.err.println(exception.toString());
    		}
    	} 
    }
    
    /**
     * ActionListener for the open button.  When the button is pressed, this ActionListener
     * opens a FileChooser, asks the user to choose a JPG image file, then
     * sets the field backgroundImageFilename in the main class.
     */
    private class OpenButtonListener implements ActionListener 
    {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose a JPG image file, then
         * sets the field backgroundImageFilename in the main class.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) 
        {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Choose a Background Image");
            chooser2.setFileFilter(new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg"));
            int returnVal = chooser2.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) 
            {
                backgroundImageFilename = chooser2.getSelectedFile().getAbsolutePath();
                backgroundImageFileNameLabel.setText(backgroundImageFilename);
            }

        }
    }
    
    /**
     * ActionListener for the save button.  When the button is pressed, this ActionListener
     * opens a save FileChooser, asks the user to choose a location and filename, then
     * writes the graphical meme data to a PNG image file.
     */
    private class SaveButtonListener implements ActionListener 
    {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose
         * a location and filename, then writes the graphical meme data to a PNG file.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) 
        {
            JFileChooser chooser2 = new JFileChooser();
            chooser2.setDialogTitle("Save Meme");
            chooser2.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            int returnVal = chooser2.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) 
            {
                String destinationFile = chooser2.getSelectedFile().getAbsolutePath();
                if (!destinationFile.contains(".png"))
                    destinationFile += ".png";
                
                // TODO: Writing an image throws a checked exception that must be handled.
                //       Catch the exceptions and provide the user with an appropriate message
                try
                {
                	ImageIO.write(currentMeme.compileMeme(), "png", new File(destinationFile));
                }
                catch(IllegalArgumentException exception)
                {
                	System.err.println(exception.toString());
                }
                catch(IOException exception)
                {
                	System.err.println(exception.toString());
                }
                catch(Exception exception)
                {
                	System.err.println(exception.toString());
                }
            
                // ImageIO.write(currentMeme.compileMeme(), "png", new File(destinationFile));

            }

        }
    }
}
