package ui;

import java.util.Scanner;

import model.NeoTunesController;

/**
 * NeoTunesManager Description: Develop a program that fulfills functions
 * similar to music content applications, as Apple Music or Spotify
 */
public class NeoTunesManager {

    public Scanner input;
    public NeoTunesController controller;

    public static void main(String[] args) {
        NeoTunesManager neoTunes = new NeoTunesManager();
        neoTunes.hello();
        neoTunes.mainMenu();
        neoTunes.bye();
        //Nicolas Cuellar Molina - A00394970 (Falto la d y la e del requerimiento 9 :( -"Sorry"-)
    }

    public NeoTunesManager() {
        input = new Scanner(System.in);
        controller = new NeoTunesController();
    }

    /**
     * Description: Print a message of welcome
     */
    public void hello() {
        System.out.println("\nWelcome to VideoGame...");
    }

    /**
     * Description: Print a message of goodbye
     */
    public void bye() {
        System.out.println("\n Exiting of the program... Thanks for use me  ");
    }

    /**
     * Description: Allows select the option of the main menu
     */
    public void mainMenu() {
        int optionMenu = 0;
        boolean exit = false;
        do {
            System.out.println(
                    "\n----------\nMain Menu\n---------- Choose a option:\n 0) Exit of program\n 1) Register a User Producer (Artist or Creator)"
                            + "\n 2) Register a User Consumer (Standard or Premium)\n 3) Register a song\n 4) Register a Podcast\n 5) Create a Playlist"
                            + "\n 6) Edit Playlist\n 7) Share Playlist\n 8) Reproducer Audio \n 9) Buy a song\n 10) Generate reports"
                            + "\n-------------------");
            optionMenu = input.nextInt();
            switch (optionMenu) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    registerUser(1);
                    break;
                case 2:
                    registerUser(2);
                    break;
                case 3:
                    registerAudio(1);
                    break;
                case 4:
                    registerAudio(2);
                    break;
                case 5:
                    createPlaylist();
                    break;
                case 6:
                    editPlaylist();
                    break;
                case 7:
                    sharePlaylist();
                    break;
                case 8:
                    reproducerAudio();
                    break;
                case 9:
                    buySong();
                    break;
                case 10:
                    generateReport();
                    break;

                default:
                    System.out.println("------------------\nValue incorrect!!!");
                    break;
            }
        } while (exit == false);
    }

    /**
     * Description: Allows select the option of the report menu
     */
    public void generateReport() {
        int optionMenu = 0;
        boolean exit = false;
        do {
            System.out.println(
                    "\n----------\nReport Menu\n---------- Choose a option:\n 0) Exit of report menu\n 1) Number of reproduction of Song and Podcast"
                            + "\n 2) The Genre most listenest\n 3) The Category most listenest\n 4) The Top 5 of Artist and Creator\n 5) The Top 10 of Songs and Podcasts"
                            + "\n 6) Songs bought of each genre\n 7) Song most buiest"
                            + "\n-------------------");
            optionMenu = input.nextInt();
            switch (optionMenu) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println(controller.totalReproductions());
                    break;
                case 2:
                    System.out.println(controller.genreSong());
                    break;
                case 3:
                    System.out.println(controller.categoryPodcast());
                    break;
                case 4:
                    System.out.println(controller.top5());
                    break;
                case 5:
                    System.out.println(controller.top10());
                    break;
                case 6:
                    System.out.println(controller.boughtGenreSong());
                    break;
                case 7:
                    System.out.println(controller.songMostbuiest());
                    break;
                default:
                    System.out.println("------------------\nValue incorrect!!!");
                    break;
            }
        } while (exit == false);
    }

    /**
     * Description: Allows buy a Song
     */
    public void buySong() {
        if (controller.showNickName(1).equals("") && controller.showNickName(2).equals("")) {
            System.out.println("First must register a Standard or a Premium!!! -------------------");
        } else {
            int numberUser = -1;
            System.out.println("This user consumer is Standard (0) or Premium (1)");
            boolean option = trueOrFalse("Standard", "Premium");
            if (option) {
                if (controller.showNickName(2).equals("")) {
                    System.out.println("First must register a Premium!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("Premium", 2);
                }
            } else {
                if (controller.showNickName(1).equals("")) {
                    System.out.println("First must register a Standard!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("standard", 1);
                }
            }
            if (numberUser != -1) {

                if (controller.showNameAudio(1).equals("")) {
                    System.out.println("First must created a Song");
                } else {
                    int numberSong = selectAudio(1);
                    if (controller.buySong(numberUser, numberSong)) {
                        System.out.println("The process was correct----------");
                    } else {
                        System.out.println("The process can't be finished----------");
                    }
                }

            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Description: Allows reproducer a Audio selected by a User selected
     */
    public void reproducerAudio() {

        if (controller.showNickName(1).equals("") && controller.showNickName(2).equals("")) {
            System.out.println("First must register a Standard or a Premium!!! -------------------");
        } else {
            int numberUser = -1;
            System.out.println("This user consumer is Standard (0) or Premium (1)");
            boolean option = trueOrFalse("Standard", "Premium");
            if (option) {
                if (controller.showNickName(2).equals("")) {
                    System.out.println("First must register a Premium!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("Premium", 2);
                }
            } else {
                if (controller.showNickName(1).equals("")) {
                    System.out.println("First must register a Standard!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("standard", 1);
                }
            }
            if (numberUser != -1) {

                if (controller.showNameAudio(0).equals("")) {
                    System.out.println("First must created a Audio");
                } else {
                    int numberAudio = selectAudio(0);
                    System.out.println(controller.reproduceAudio(numberUser, numberAudio));
                }

            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Description: Allows share the Auto-id of a Playlist selected
     */
    public void sharePlaylist() {

        if (controller.showNickName(1).equals("") && controller.showNickName(2).equals("")) {
            System.out.println("First must register a Standard or a Premium!!! -------------------");
        } else {
            int numberUser = -1;
            System.out.println("This user consumer is Standard (0) or Premium (1)");
            boolean option = trueOrFalse("Standard", "Premium");
            if (option) {
                if (controller.showNickName(2).equals("")) {
                    System.out.println("First must register a Premium!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("Premium", 2);
                }
            } else {
                if (controller.showNickName(1).equals("")) {
                    System.out.println("First must register a Standard!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("standard", 1);
                }
            }
            if (numberUser != -1) {
                // Process of share with auto-id
                if (controller.showNamePlaylist(numberUser).equals("")) {
                    System.out.println("First must created a Playlist");
                } else {

                    int numberPlaylist = selectPlaylist(numberUser);
                    System.out.println(controller.sharePlaylist(numberUser, numberPlaylist));
                }
            } else {
                System.out.println("The process can't be finished----------");
            }
        }

    }

    /**
     * Description: Allows select the Consumer (Standard or Premium) that edited the
     * Playlist
     */
    public void editPlaylist() {
        if (controller.showNickName(1).equals("") && controller.showNickName(2).equals("")) {
            System.out.println("First must register a Standard or a Premium!!! -------------------");
        } else {
            int numberUser = -1;
            System.out.println("This user consumer is Standard (0) or Premium (1)");
            boolean option = trueOrFalse("Standard", "Premium");
            if (option) {
                if (controller.showNickName(2).equals("")) {
                    System.out.println("First must register a Premium!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("Premium", 2);
                }
            } else {
                if (controller.showNickName(1).equals("")) {
                    System.out.println("First must register a Standard!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("standard", 1);
                }
            }
            if (numberUser != -1) {
                if (controller.showNamePlaylist(numberUser).equals("")) {
                    System.out.println("First must created a Playlist");
                } else {
                    editMenuPlaylist(numberUser);
                }
            }
        }
    }

    /**
     * Description: Allows select the Playlist and edit it with the options of this
     * menu
     * 
     * @param numberUser int The index of the User that want to edit a Playlist
     */
    public void editMenuPlaylist(int numberUser) {
        int numberPlaylist = selectPlaylist(numberUser);
        int optionMenu = 0;
        boolean exit = false;
        do {
            System.out.println(
                    "\n----------\nPlaylist Menu\n---------- Choose a option:\n 0) Exit of menu\n 1) Add a Song"
                            + "\n 2) Delete a Song \n 3) Rename the Playlist");
            optionMenu = input.nextInt();
            switch (optionMenu) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    addSong(numberUser, numberPlaylist);
                    break;
                case 2:
                    deleteSong(numberUser, numberPlaylist);
                    break;
                case 3:
                    renamePlaylist(numberUser, numberPlaylist);
                    break;
                default:
                    System.out.println("------------------\nValue incorrect!!!");
                    break;
            }
        } while (exit == false);
    }

    /**
     * Description: Allows add a Song to a Playlist of a User
     * 
     * @param numberUser     The index of User that has a Playlist
     * @param numberPlaylist The index of the Playlist that add the Song
     */
    public void addSong(int numberUser, int numberPlaylist) {
        if (controller.showNameAudio(0).equals("")) {
            System.out.println("First must created a Audio");
        } else {
            int numberAudio = selectAudio(0);
            if (controller.addAudioToPlaylist(numberUser, numberPlaylist, numberAudio)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Description: Allows delete a Song to a Playlist of a User
     * 
     * @param numberUser     The index of User that has a Playlist
     * @param numberPlaylist The index of the Playlist that delete the Song
     */
    public void deleteSong(int numberUser, int numberPlaylist) {
        if (controller.showAudiosOfPlaylist(numberUser, numberPlaylist).equals("")) {
            System.out.println("First must created a Audio");
        } else {
            System.out.println(controller.showAudiosOfPlaylist(numberUser, numberPlaylist));
            System.out.println("Enter the Audio index for delete: ");
            int numberAudio = input.nextInt();
            if (controller.deleteAudioToPlaylist(numberUser, numberPlaylist, numberAudio)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Description: Allows rename a Playlist of a User
     * 
     * @param numberUser     The index of User that has a Playlist
     * @param numberPlaylist The index of the Playlist that will rename
     */
    public void renamePlaylist(int numberUser, int numberPlaylist) {
        input.nextLine();
        System.out.println("Enter the new name: ");
        String newName = input.nextLine();
        if (controller.setNamePlaylist(numberUser, numberPlaylist, newName)) {
            System.out.println("The process was correct----------");
        } else {
            System.out.println("The process can't be finished----------");
        }
    }

    /**
     * Description: Allows create a Playlist
     */
    public void createPlaylist() {
        if (controller.showNickName(1).equals("") && controller.showNickName(2).equals("")) {
            System.out.println("First must register a Standard or a Premium!!! -------------------");
        } else {
            int numberUser = -1;
            System.out.println("This user consumer is Standard (0) or Premium (1)");
            boolean option = trueOrFalse("Standard", "Premium");
            if (option) {
                if (controller.showNickName(2).equals("")) {
                    System.out.println("First must register a Premium!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("Premium", 2);
                }
            } else {
                if (controller.showNickName(1).equals("")) {
                    System.out.println("First must register a Standard!!! -------------------");
                } else {
                    numberUser = selectStandardOrPremiumOrArtistOrCreator("standard", 1);
                }
            }
            if (numberUser != -1) {
                System.out.println("Enter the name of the new Playlist: ");
                String name = input.nextLine();
                if (controller.createPlaylist(numberUser, name)) {
                    System.out.println("The process was correct----------");
                } else {
                    System.out.println("The process can't be finished----------");
                }
            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Description: Allows register a new Audio
     * 
     * @param songOrPodcast if is song is equal to 1, else is equal to 2
     */
    public void registerAudio(int songOrPodcast) {
        if (songOrPodcast == 1 && controller.showNickName(3).equals("")) {
            System.out.println("First must register a Artist!!! -------------------");
        } else if (songOrPodcast == 2 && controller.showNickName(4).equals("")) {
            System.out.println("First must register a Creator!!! -------------------");
        } else {
            int numberUser = 0;
            if (songOrPodcast == 1) {
                numberUser = selectStandardOrPremiumOrArtistOrCreator("Artist", 3);
            } else {
                numberUser = selectStandardOrPremiumOrArtistOrCreator("Creator", 4);
            }
            boolean exit = false;
            String name = "";
            do {
                System.out.println("Audio:\n Enter the name: ");
                name = input.nextLine();
                if (controller.searchAudio(name) != -1) {
                    System.out.println("This name already exists, please enter another: ");
                } else {
                    exit = true;
                }
            } while (exit == false);
            System.out.println("Enter the url of a image for show: ");
            String url = input.nextLine();
            System.out.println("\n Enter the Duration of the song: ");
            System.out.println("Seconds (int)");
            int duration = input.nextInt();
            if (songOrPodcast == 1) {
                registerSong(numberUser, name, url, duration);
            } else {
                registerPodcast(numberUser, name, url, duration);
            }
        }
    }

    /**
     * Description: Allows register a new Podcast
     * 
     * @param numberArtist Is the attribute of the class Audio
     * @param name         Is the attribute of the class Audio
     * @param url          Is the attribute of the class Audio
     * @param duration     Is the attribute of the class Audio
     */
    public void registerPodcast(int numberArtist, String name, String url, int duration) {
        input.nextLine();
        System.out.println("Enter the description: ");
        String description = input.nextLine();
        int typeCategory = selectTypeCategory();
        if (controller.createPodcast(numberArtist, name, url, duration, description, typeCategory)) {
            System.out.println("The process was correct----------");
        } else {
            System.out.println("The process can't be finished----------");
        }
    }

    /**
     * Description: Allows register a new Podcast
     * 
     * @param numberArtist Is the attribute of the class Audio
     * @param name         Is the attribute of the class Audio
     * @param url          Is the attribute of the class Audio
     * @param duration     Is the attribute of the class Audio
     */
    public void registerSong(int numberArtist, String name, String url, int duration) {
        input.nextLine();
        System.out.println("Enter the name of album");
        String album = input.nextLine();
        System.out.println("Enter the Value of Sale");
        double saleValue = input.nextDouble();
        int typeGenre = selectTypeGenre();
        if (controller.createSong(numberArtist, name, url, duration, album, saleValue, typeGenre)) {
            System.out.println("The process was correct----------");
        } else {
            System.out.println("The process can't be finished----------");
        }
    }

    /**
     * Description: Allows select a Audio registered
     * 
     * @param songOrPodcast int the Song (1) or Podcast (2) or All (0)
     * @return int The index of Audio selected
     */
    public int selectAudio(int songOrPodcast) {
        System.out.println(controller.showNameAudio(songOrPodcast));
        System.out.println("Enter the Audio index: ");
        int numberAudio = input.nextInt();
        return numberAudio;
    }

    /**
     * Description: Allow select a Playlist of a User
     * 
     * @param numberUser The index of user
     * @return int The index of the Playlist selected
     */
    public int selectPlaylist(int numberUser) {
        System.out.println(controller.showNamePlaylist(numberUser));
        System.out.println("Enter the Playlist index for continue");
        int numberPlaylist = input.nextInt();
        return numberPlaylist;
    }

    /**
     * Description: Allow select a User Standard, or Premium, or Artist, or Creator
     * 
     * @param aOrC                               String The name del User for search
     *                                           and show (Standard : Premium :
     *                                           Artist : Creator)
     * @param standardOrPremiumOrArtistOrCreator int The type of User that want
     *                                           select (1-Standard
     *                                           : 2-Premium : 3-Artist : 4-Creator)
     * @return int The index of User selected
     */
    public int selectStandardOrPremiumOrArtistOrCreator(String aOrC, int standardOrPremiumOrArtistOrCreator) {
        int numberUser = 0;
        System.out.println(controller.showNickName(standardOrPremiumOrArtistOrCreator));
        System.out.println("\nEnter the " + aOrC + " nickName -----------------");
        boolean exit = false;
        input.nextLine();
        String nickName = "";
        do {
            System.out.println("" + aOrC + ":\n Enter the nickName: ");
            nickName = input.nextLine();
            if (controller.searchUser(nickName) == -1) {
                System.out.println("This nickName don't exist, please enter another: ");
            } else {
                numberUser = controller.searchUser(nickName);
                exit = true;
            }
        } while (exit == false);
        return numberUser;
    }

    /**
     * Description: Allows select a type of Genre
     * 
     * @return int The index of the type of Genre (1 : 2 : 3 : 4)
     */
    public int selectTypeGenre() {
        boolean exit = false;
        int typeGenre = 0;
        System.out.println(controller.toStringGenre());
        do {
            System.out.println("Enter the number of type of Genre: ");
            typeGenre = input.nextInt();
            if (typeGenre < 0 || typeGenre > 3) {
                System.out.println("There isn't this type of Genre, please enter another: ");
            } else {
                exit = true;
            }
        } while (exit == false);
        return typeGenre;
    }

    /**
     * Description: Allows select a type of Category
     * 
     * @return int The index of the type of Category (1 : 2 : 3 : 4)
     */
    public int selectTypeCategory() {
        boolean exit = false;
        int typeCategory = 0;
        System.out.println(controller.toStringCategory());
        do {
            System.out.println("Enter the number of type of Category: ");
            typeCategory = input.nextInt();
            if (typeCategory < 0 || typeCategory > 3) {
                System.out.println("There isn't this type of Category, please enter another: ");
            } else {
                exit = true;
            }
        } while (exit == false);
        return typeCategory;
    }

    /**
     * Description: Allows register a new User (Producer or Consumer)
     * 
     * @param producerOrConsumer int The type of User (1-Producer : 2-Consumer)
     */
    public void registerUser(int producerOrConsumer) {
        boolean exit = false;
        input.nextLine();
        String nickName = "";
        do {
            System.out.println("User:\n Enter the nickName: ");
            nickName = input.nextLine();
            if (controller.searchUser(nickName) != -1) {
                System.out.println("This nickname already exists, please enter another: ");
            } else {
                exit = true;
            }
        } while (exit == false);
        System.out.println("Enter the id: ");
        String id = input.nextLine();
        if (producerOrConsumer == 1) {
            registerProducer(nickName, id);
        } else {
            registerConsumer(nickName, id);
        }
    }

    /**
     * Description: Allow register a new Consumer (Standard or Premium)
     * 
     * @param nickName Is the attribute of the class User
     * @param id       Is the attribute of the class User
     */
    public void registerConsumer(String nickName, String id) {
        System.out.println("This user consumer is Standard (0) or Premium (1)");
        boolean option = trueOrFalse("Standard", "Premium");
        if (option) {
            if (controller.registerPremium(nickName, id)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        } else {
            if (controller.registerStandard(nickName, id)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Description: Allow register a new Producer (Artist or Creator)
     * 
     * @param nickName Is the attribute of the class User
     * @param id       Is the attribute of the class User
     */
    public void registerProducer(String nickName, String id) {
        System.out.println("This user producer is Artist (0) or Creator (1)");
        boolean option = trueOrFalse("Artist", "Creator");
        input.nextLine();
        System.out.println("Enter the name: ");
        String name = input.nextLine();
        System.out.println("Enter the url of a image for show: ");
        String url = input.nextLine();
        if (option) {
            if (controller.registerCreator(nickName, id, name, url)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        } else {
            if (controller.registerArtist(nickName, id, name, url)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Description: Allows select between two options
     * 
     * @param condition0False The option 0, will False
     * @param condition1True  The option 1, will True
     * @return boolean (False-0 : True-1)
     */
    public boolean trueOrFalse(String condition0False, String condition1True) {
        int option = 0;
        do {
            System.out.println("(Enter 0 for " + condition0False + " or 1 for " + condition1True + ")");
            option = input.nextInt();
        } while (option < 0 && option > 1);
        if (option == 0) {
            return false;
        } else {
            return true;
        }
    }

}