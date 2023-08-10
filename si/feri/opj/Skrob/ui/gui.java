package si.feri.opj.Skrob.ui;

import si.feri.opj.Skrob.athleticsClasses.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class gui {
    private JTabbedPane tabbedPanel;
    private JTextField AthleteName;
    private JTextField AthleteSurname;
    private JTextField AthleteNumber;
    private JTextField AthleteDateOfBirth;
    private JButton AthleteAddButton;
    private JList listOfAthletes;
    private JButton AthleteDeleteButton;
    private JButton AthleteEditButton;
    private JTextField VenueName;
    private JTextField VenuePhoneNumber;
    private JComboBox VenueDiscipline;
    private JTextField EventName;
    private JCheckBox EventCanceled;
    private JComboBox AthleteDiscipline;
    private JPanel MainPanel;
    private JTextField VenueNumberOfAddHalls;
    private JList listOfVenues;
    private JButton VenueAddButton;
    private JButton VenueDeleteButton;
    private JButton VenueEditButton;
    private JList EventList;
    private JButton EventAddButton;
    private JButton EventDeleteButton;
    private JButton EventEditButton;
    private JList EventsToManageList;
    private JList AthletesInEventList;
    private JButton mAthleteRemoveButton;
    private JList AthletesOutEventList;
    private JButton mAthleteAddButton;
    private JButton mEventChooseButton;
    private JList mVenueListRemove;
    private JList mEventListRemove;
    private JButton removeEventFromVenueButton;
    private JList mVenueListAdd;
    private JList mEventListAdd;
    private JButton addEventToVenueButton;
    private JButton changePanelButtonRemove;
    private JButton changePanelButtonAdd;
    private JComboBox VenueType;
    private JTextField EventSchedule;
    private JTextField VenueNumberOfMatches;
    private JPanel manageVenues;
    private JPanel removeFromVenue;
    private JPanel addToVenue;
    private JTextField EventTrainerName;
    private JComboBox EventType;
    private JButton chooseVenueButton;


    private ArrayList<Athlete> arrayListAthlets = new ArrayList<Athlete>();
    private DefaultListModel<Athlete> listModelAthletes = new DefaultListModel<Athlete>();


    private ArrayList<Event> arrayListEvents = new ArrayList<Event>();
    private  DefaultListModel<Event> listModelEvents = new DefaultListModel<Event>();


    private ArrayList<Venue> arrayListVenues = new ArrayList<Venue>();
    private  DefaultListModel<Venue> listModelVenues = new DefaultListModel<Venue>();


    private DefaultListModel<Athlete> listModelAthletesInEvent = new DefaultListModel<Athlete>();
    private  DefaultListModel<Event> listModelEventsInVenue = new DefaultListModel<Event>();

    public gui() {
        AthleteAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Athlete human = new Athlete(AthleteName.getText(), AthleteSurname.getText(), Integer.parseInt(AthleteNumber.getText()), LocalDate.parse(AthleteDateOfBirth.getText()), (Discipline) AthleteDiscipline.getSelectedItem());
                //Athlete human = new Athlete(AthleteName.getText(), AthleteSurname.getText());
                arrayListAthlets.add(human);
                listOfAthletes.setModel(listModelAthletes);
                listModelAthletes.addElement(human);

                AthletesOutEventList.setModel(listModelAthletes);

                for(Athlete man : arrayListAthlets)
                    System.out.println(man);
            }


        });
        AthleteEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listOfAthletes.getSelectedIndex();
                if(index!= -1){
                    //Athlete human = listModelAthletes.elementAt(index);
                    Athlete human = arrayListAthlets.get(index);
                    human.setName(AthleteName.getText());
                    human.setSurname(AthleteSurname.getText());
                    human.setAthleteNumber(Integer.parseInt(AthleteNumber.getText()));
                    human.setDateOfBirth(LocalDate.parse(AthleteDateOfBirth.getText()));
                    human.setDiscipline((Discipline) AthleteDiscipline.getSelectedItem());
                    //listModelAthletes.elementAt(index).setName(AthleteName.getText());
                    //listModelAthletes.elementAt(index).setSurname(AthleteSurname.getText());
                    //listOfAthletes.setModel(listModelAthletes);
                    listModelAthletes.setElementAt(human, index);
                }
            }
        });

        AthleteDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listOfAthletes.getSelectedIndex();
                if(index!= -1){
                    //Athlete human = listModelAthletes.elementAt(index);
                    //Athlete human = arrayListAthlets.get(index);
                    //human = null;
                    arrayListAthlets.remove(index);
                    listModelAthletes.remove(index);
                }
            }
        });
        VenueAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Venue place;
                if(VenueType.getSelectedItem() == "-Stadium") {
                    place = new Stadium(VenueName.getText(), VenuePhoneNumber.getText(), (Discipline) AthleteDiscipline.getSelectedItem(), Integer.parseInt(VenueNumberOfMatches.getText()));
                }
                else{
                    place = new Hall(VenueName.getText(), VenuePhoneNumber.getText(), (Discipline) AthleteDiscipline.getSelectedItem(), Integer.parseInt(VenueNumberOfMatches.getText()), Integer.parseInt(VenueNumberOfAddHalls.getText()));
                }
                arrayListVenues.add(place);
                listOfVenues.setModel(listModelVenues);
                listModelVenues.addElement(place);

                mVenueListRemove.setModel(listModelVenues);

                mVenueListAdd.setModel(listModelVenues);

                for(Venue pla : arrayListVenues)
                    System.out.println(pla);
            }
        });



        VenueDeleteButton.addActionListener(new ListenerVenueDelete(arrayListVenues, listModelVenues, listOfVenues));


        changePanelButtonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToVenue.show();
                removeFromVenue.hide();
            }
        });

        changePanelButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToVenue.hide();
                removeFromVenue.show();
            }
        });

        EventAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Event event;
                //event = new Event(EventName.getText(), new Schedule(LocalDateTime.parse(EventSchedule.getText())), EventCanceled.isSelected());
                if(EventType.getSelectedItem() == "-Match"){
                    event = new Match(EventName.getText(), new Schedule(LocalDateTime.parse(EventSchedule.getText())), EventCanceled.isSelected());
                }else{
                    event = new Training(EventName.getText(), new Schedule(LocalDateTime.parse(EventSchedule.getText())), EventCanceled.isSelected(), EventTrainerName.getText());
                }

                arrayListEvents.add(event);
                EventList.setModel(listModelEvents);
                listModelEvents.addElement(event);

                mEventListAdd.setModel(listModelEvents);

                EventsToManageList.setModel(listModelEvents);
            }
        });


        EventEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = EventList.getSelectedIndex();
                if(index!= -1){
                    //Athlete human = listModelAthletes.elementAt(index);
                    Event event = arrayListEvents.get(index);

                    event.setName(EventName.getText());
                    event.setCancelled(EventCanceled.isSelected());
                    event.setSchedule(new Schedule(LocalDateTime.parse(EventSchedule.getText())));

                    listModelEvents.setElementAt(event, index);
                }
            }
        });


        EventDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = EventList.getSelectedIndex();
                if(index!= -1){
                    //Athlete human = listModelAthletes.elementAt(index);
                    //Athlete human = arrayListAthlets.get(index);
                    //human = null;
                    arrayListEvents.remove(index);
                    listModelEvents.remove(index);
                }
            }
        });

        mEventChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModelAthletesInEvent = new DefaultListModel<Athlete>();
                int index = EventsToManageList.getSelectedIndex();
                if(index!= -1 && (arrayListEvents.get(index) instanceof Match)){
                    Match match = (Match) arrayListEvents.get(index);
                    for(int i=0; i < match.getAthletesList().length;i++){
                        listModelAthletesInEvent.addElement(match.getAthletesList()[i]);
                    }
                    System.out.println("nastalo");
                    AthletesInEventList.setModel(listModelAthletesInEvent);
                }

                EventsToManageList.setModel(listModelEvents);
            }
        });
        mAthleteAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexEvent = EventsToManageList.getSelectedIndex();
                int indexAthlet = AthletesOutEventList.getSelectedIndex();
                if((indexEvent != -1) && (indexAthlet != -1) && (arrayListEvents.get(indexEvent) instanceof Match)){
                    Match match = (Match) arrayListEvents.get(indexEvent);
                    Athlete athlete = arrayListAthlets.get(indexAthlet);
                    try {
                        match.addAthleteToMatch(athlete);
                    } catch (AddingAthleteException ex) {
                        throw new RuntimeException(ex);
                    }

                    System.out.println(match.getAthletesList());
                    System.out.println(match.getNumberOfAthletesInMatch());
                }else {
                    System.out.println("Athlete was not added.");
                }
            }
        });

        mAthleteRemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexEvent = EventsToManageList.getSelectedIndex();
                int indexAthlete = AthletesInEventList.getSelectedIndex();
                if(indexEvent != -1 && indexAthlete != -1){
                    Athlete athlete = listModelAthletesInEvent.get(indexAthlete);
                    Match match = (Match) listModelEvents.get(indexEvent);
                    match.removeAthleteFromMatch(athlete.getAthleteNumber());
                    listModelAthletesInEvent.remove(indexAthlete);
                }
            }
        });

        addEventToVenueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexVenue = mVenueListAdd.getSelectedIndex();
                int indexEvent = mEventListAdd.getSelectedIndex();
                if(indexEvent != -1 && indexVenue != -1){
                    Venue venue = listModelVenues.get(indexVenue);
                    Event event = listModelEvents.get(indexEvent);
                    if(event instanceof Match){
                        try {
                            venue.addMatch((Match) event);
                        } catch (AddingMatchException ex) {
                            throw new RuntimeException(ex);
                        } catch (SportDisciplineException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });

        chooseVenueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModelEventsInVenue = new DefaultListModel<Event>();
                int index = mVenueListRemove.getSelectedIndex();
                if(index != -1){
                    Venue venue = arrayListVenues.get(index);
                    for(int i=0; i < venue.getListOfMatches().length; i++){
                        listModelEventsInVenue.addElement(venue.getListOfMatches()[i]);
                    }
                }

                mEventListRemove.setModel(listModelEventsInVenue);
            }
        });

        removeEventFromVenueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexEvent = mEventListRemove.getSelectedIndex();
                int indexVenue = mVenueListRemove.getSelectedIndex();
                if(indexVenue != -1){
                    Event event = arrayListEvents.get(indexEvent);
                    Venue venue = arrayListVenues.get(indexVenue);
                    venue.removeMatches();
                    listModelEventsInVenue = new DefaultListModel<Event>();
                    mEventListRemove.setModel(listModelEventsInVenue);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("gui");
        frame.setContentPane(new gui().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.AthleteDiscipline = new JComboBox(Discipline.values());
        this.VenueDiscipline = new JComboBox(Discipline.values());
    }
}
