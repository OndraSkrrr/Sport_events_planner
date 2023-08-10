package si.feri.opj.Skrob.ui;

import si.feri.opj.Skrob.athleticsClasses.Venue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListenerVenueDelete implements ActionListener {
    /*
    private JTextField VenueName;
    private JTextField VenuePhoneNumber;
    private JComboBox VenueDiscipline;

    private JButton VenueAddButton;
    private JButton VenueDeleteButton;
    private JButton VenueEditButton;
    private JComboBox VenueType;
    */
    private JList listOfVenues;
    private ArrayList<Venue> arrayListVenues;
    private  DefaultListModel<Venue> listModelVenues;

    public ListenerVenueDelete(ArrayList<Venue> arrayListVenues, DefaultListModel<Venue> listModelVenues, JList<Venue> listOfVenues) {
        /*
        this.VenueName = venueName;
        this.VenuePhoneNumber = venuePhoneNumber;
        this.VenueDiscipline = venueDiscipline;

        this.VenueAddButton = venueAddButton;
        this.VenueDeleteButton = venueDeleteButton;
        this.VenueEditButton = venueEditButton;
        this.VenueType = venueType;
        */
        this.listOfVenues = listOfVenues;

        this.arrayListVenues = arrayListVenues;
        this.listModelVenues = listModelVenues;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = listOfVenues.getSelectedIndex();
        if(index!= -1){
            //Athlete human = listModelAthletes.elementAt(index);
            //Athlete human = arrayListAthlets.get(index);
            //human = null;
            arrayListVenues.remove(index);
            listModelVenues.remove(index);
        }
    }
}
