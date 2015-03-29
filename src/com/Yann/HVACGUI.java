package com.Yann;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

/**
 * Created by Yanirash on 3/29/2015.
 */
public class HVACGUI extends JFrame {
    private JComboBox ServiceType;
    private JTextField Address;
    private JTextField problemEntree;
    private JComboBox modeltype;
    private JButton addTheService;
    private JPanel rootPanal;
    private JList<ServiceCall> serviceList;
    private JButton displayInfo;
    private JLabel myLabel;


    DefaultListModel<ServiceCall> serviceListModel;






    public HVACGUI() {
        super("Service Calls");
        setContentPane(rootPanal);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(200,500);

        final String FURNACE = "Furnace";
        final String AC = "AC Unit";
        final String FORCED_AIR = "Forced Air";
        final String BOILER = "Boiler/Radiators";
        final String OCTOPUS = "Older Octopus Style";


        ServiceType.addItem(FURNACE);
        ServiceType.addItem(AC);
        modeltype.addItem(FORCED_AIR);
        modeltype.addItem(BOILER);
        modeltype.addItem(OCTOPUS);

        serviceListModel = new DefaultListModel<ServiceCall>();
        serviceList.setModel(serviceListModel);
        serviceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        Address.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        problemEntree.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        modeltype.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String furnaceChoice = (String) modeltype.getSelectedItem();

            }
        });

        ServiceType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String acChoice = (String)ServiceType.getSelectedItem();
                if (acChoice.equals(AC)) {
                    myLabel.setText("Please Enter your AC model");
                }
            }
        });

        addTheService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yourAddress = Address.getText();
                String problem = problemEntree.getText();

                Date date = new Date();


                String furnaceChoice = (String)modeltype.getSelectedItem();
                String choice = (String)ServiceType.getSelectedItem();
                if (choice.equals(FURNACE)) {
                    Furnace service = new Furnace(yourAddress, problem, date, furnaceChoice);
                    HVACGUI.this.serviceListModel.addElement(service);
                } else {
                    CentralAC serviceAC = new CentralAC(yourAddress,problem,date,choice);
                    HVACGUI.this.serviceListModel.addElement(serviceAC);
                }



            }
        });
        displayInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serviceList.setVisible(true);

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
