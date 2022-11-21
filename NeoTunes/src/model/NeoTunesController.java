package model;

import java.util.ArrayList;
import java.util.Random;

public class NeoTunesController {

    private ArrayList<User> users;
    private ArrayList<Audio> audios;

    public NeoTunesController() {
        this.users = new ArrayList<User>();
        this.audios = new ArrayList<Audio>();

    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Description: Allows get the index of a User nickName
     * 
     * @param nickName The nickName of User for search
     * @return The index of User searched (-1 if don't exist)
     */
    public int searchUser(String nickName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null) {
                if (users.get(i).getNickName().equals(nickName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Description: Allows get the index of a Audio name
     * 
     * @param name The name of Audio for search
     * @return The index of Audio searched (-1 if don't exist)
     */
    public int searchAudio(String name) {
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) != null) {
                if (audios.get(i).getName().equals(name)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Description: Print the list of the enumeration TypeGenre
     * 
     * @return String The elements as a list
     */
    public String toStringGenre() {
        TypeGenre typeGenre[] = TypeGenre.values();
        String msg = "Type of Genres: ";
        for (int i = 0; i < typeGenre.length; i++) {
            msg += "\n " + i + ") " + typeGenre[i];
        }
        return msg;
    }

    /**
     * Description: Print the list of the enumeration TypeCategory
     * 
     * @return String The elements as a list
     */
    public String toStringCategory() {
        TypeCategory typeCategory[] = TypeCategory.values();
        String msg = "Type of Category: ";
        for (int i = 0; i < typeCategory.length; i++) {
            msg += "\n " + i + ") " + typeCategory[i];
        }
        return msg;
    }

    /**
     * Description: Create a new Artist
     * 
     * @param nickName Attribute of the class
     * @param id       Attribute of the class
     * @param name     Attribute of the class
     * @param url      Attribute of the class
     * @return boolean
     */
    public boolean registerArtist(String nickName, String id, String name, String url) {
        User newArtist = new Artist(nickName, id, name, url);
        return users.add(newArtist);
    }

    /**
     * Description: Create a new Crator
     * 
     * @param nickName Attribute of the class
     * @param id       Attribute of the class
     * @param name     Attribute of the class
     * @param url      Attribute of the class
     * @return boolean
     */
    public boolean registerCreator(String nickName, String id, String name, String url) {
        User newCreator = new Creator(nickName, id, name, url);
        return users.add(newCreator);
    }

    /**
     * Description: Create a new Standard
     * 
     * @param nickName Attribute of the class
     * @param id       Attribute of the class
     * @return boolean
     */
    public boolean registerStandard(String nickName, String id) {
        User newStandard = new Standard(nickName, id);
        return users.add(newStandard);
    }

    /**
     * Description: Create a new Premium
     * 
     * @param nickName Attribute of the class
     * @param id       Attribute of the class
     * @return boolean
     */
    public boolean registerPremium(String nickName, String id) {
        User newPremium = new Premium(nickName, id);
        return users.add(newPremium);
    }

    /**
     * Description: Print the list of User required
     * 
     * @param standardOrPremiumOrArtistOrCreator int The type of User that want show
     *                                           (0-All : 1-Standard : 2-Premium :
     *                                           3-Artist : 4-Creator)
     * @return String The list of the nickNames
     */
    public String showNickName(int standardOrPremiumOrArtistOrCreator) {
        String msg = "";
        for (int i = 0; i < users.size(); i++) {
            if (!users.isEmpty()) {
                switch (standardOrPremiumOrArtistOrCreator) {
                    case 0:
                        msg += "\n" + (i) + ") " + users.get(i).getNickName();
                        break;
                    case 1:
                        if (users.get(i) instanceof Standard) {
                            msg += "\n" + (i) + ") " + users.get(i).getNickName();
                        }
                        break;
                    case 2:
                        if (users.get(i) instanceof Premium) {
                            msg += "\n" + (i) + ") " + users.get(i).getNickName();
                        }
                        break;
                    case 3:
                        if (users.get(i) instanceof Artist) {
                            msg += "\n" + (i) + ") " + users.get(i).getNickName();
                        }
                        break;
                    case 4:
                        if (users.get(i) instanceof Creator) {
                            msg += "\n" + (i) + ") " + users.get(i).getNickName();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return msg;
    }

    /**
     * Description: Print the list of Audio required
     * 
     * @param songOrPodcast int The type of Audio that want show (0-All : 1-Song :
     *                      2-Podcast)
     * @return String The list of names
     */
    public String showNameAudio(int songOrPodcast) {
        String msg = "";
        for (int i = 0; i < audios.size(); i++) {
            if (!audios.isEmpty()) {
                switch (songOrPodcast) {
                    case 0:
                        msg += "\n" + (i) + ") " + audios.get(i).getName();
                        break;
                    case 1:
                        if (audios.get(i) instanceof Song) {
                            msg += "\n" + (i) + ") " + audios.get(i).getName();
                        }
                        break;
                    case 2:
                        if (audios.get(i) instanceof Podcast) {
                            msg += "\n" + (i) + ") " + audios.get(i).getName();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return msg;
    }

    /**
     * Description: Print the list of Playlist
     * 
     * @param numberUser The index of User that has the Playlist
     * @return String The list of names
     */
    public String showNamePlaylist(int numberUser) {
        String msg = "";
        if (users.get(numberUser) instanceof Standard) {
            for (int i = 0; i < ((Standard) users.get(numberUser)).getPlaylists().size(); i++) {
                msg += "\n" + (i) + ") " + ((Standard) users.get(numberUser)).getPlaylists().get(i).getName();
            }
        } else if (users.get(numberUser) instanceof Premium) {
            for (int i = 0; i < ((Premium) users.get(numberUser)).getPlaylist().size(); i++) {
                msg += "\n" + (i) + ") " + ((Premium) users.get(numberUser)).getPlaylist().get(i).getName();
            }
        } else {
        }
        return msg;
    }

    /**
     * Description: Print the list of Audios of a Playlist
     * 
     * @param numberUser     The User that has the Playlist
     * @param numberPlaylist The Playlist that has the Audios for show
     * @return String The list of names
     */
    public String showAudiosOfPlaylist(int numberUser, int numberPlaylist) {
        String msg = "";
        if (users.get(numberUser) instanceof Standard) {
            for (int i = 0; i < ((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist).getAudios()
                    .size(); i++) {
                msg += "\n" + (i) + ") " + ((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist)
                        .getAudios().get(i).getName();
            }
        } else if (users.get(numberUser) instanceof Premium) {
            for (int i = 0; i < ((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist).getAudios()
                    .size(); i++) {
                msg += "\n" + (i) + ") " + ((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist)
                        .getAudios().get(i).getName();
            }
        } else {
        }
        return msg;
    }

    /**
     * Description: Create a new Song
     * 
     * @param numberUser The User that created the Song
     * @param name       Attribute of the class
     * @param url        Attribute of the class
     * @param duration   Attribute of the class
     * @param album      Attribute of the class
     * @param saleValue  Attribute of the class
     * @param typeGenre  Attribute of the class
     * @return boolean
     */
    public boolean createSong(int numberUser, String name, String url, int duration, String album,
            double saleValue, int typeGenre) {
        Audio newSong = new Song(name, url, duration, album, saleValue, typeGenre);
        audios.add(newSong);
        return ((Artist) users.get(numberUser)).addSong((Song) newSong);
    }

    /**
     * Description: Create a new Podcast
     * 
     * @param numberUser   The User that created the Podcast
     * @param name         Attribute of the class
     * @param url          Attribute of the class
     * @param duration     Attribute of the class
     * @param description  Attribute of the class
     * @param typeCategory Attribute of the class
     * @return boolean
     */
    public boolean createPodcast(int numberUser, String name, String url, int duration,
            String description, int typeCategory) {
        Audio newPodcast = new Podcast(name, url, duration, description, typeCategory);
        audios.add(newPodcast);
        return ((Creator) users.get(numberUser)).addPodcast((Podcast) newPodcast);
    }

    /**
     * Description: Create a new Playlits for a User
     * 
     * @param numberUser The User that want add a Playlist
     * @param name       Attribute of the class
     * @return boolean
     */
    public boolean createPlaylist(int numberUser, String name) {
        Playlist newPlaylist = new Playlist(name);
        if (users.get(numberUser) instanceof Standard) {
            if (((Standard) users.get(numberUser)).getPlaylists().size() < 21) {
                return ((Standard) users.get(numberUser)).addPlaylist(newPlaylist);
            } else {
                return false;
            }
        } else {
            return ((Premium) users.get(numberUser)).addPlaylist(newPlaylist);
        }
    }

    /**
     * Description: Add a Audio to a Playlist
     * 
     * @param numberUser     The User that want add a Audio to a Playlist
     * @param numberPlaylist The Playlist where the Audio will be added
     * @param numberAudio    The Audio to add
     * @return boolean
     */
    public boolean addAudioToPlaylist(int numberUser, int numberPlaylist, int numberAudio) {
        Audio tmp = audios.get(numberAudio); // Copy
        if (users.get(numberUser) instanceof Standard) {
            return ((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist).addAudio(tmp);
        } else {
            return ((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist).addAudio(tmp);
        }
    }

    /**
     * Description: Delete a Audio of a Playlist
     * 
     * @param numberUser     The User that want delete a Audio to a Playlist
     * @param numberPlaylist The Playlist where the Audio will be deleted
     * @param numberAudio    The Audio to delete
     * @return boolean
     */
    public boolean deleteAudioToPlaylist(int numberUser, int numberPlaylist, int numberAudio) {
        if (users.get(numberUser) instanceof Standard) {
            return ((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist).deleteAudio(numberAudio);
        } else {
            return ((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist).deleteAudio(numberAudio);
        }
    }

    /**
     * Description: Rename a Playlist registered
     * 
     * @param numberUser     The User that want rename a Playlist
     * @param numberPlaylist The Playlist that will be renamed
     * @param newName        The new name of the Playlist
     * @return boolean
     */
    public boolean setNamePlaylist(int numberUser, int numberPlaylist, String newName) {
        if (users.get(numberUser) instanceof Standard) {
            ((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist).setName(newName);
            return true;
        } else {
            ((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist).setName(newName);
            return true;
        }
    }

    /**
     * Description: Generate the Auto-id for share
     * 
     * @param numberUser     The User that want share a Playlist
     * @param numberPlaylist The Playlist that will be share
     * @return The Auto-id
     */
    public String sharePlaylist(int numberUser, int numberPlaylist) {
        String msg = "\n";
        Random random = new Random();
        int[][] tmp = new int[6][6];
        // Create
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < 6; j++) {
                tmp[i][j] = random.nextInt(10);
            }
        }
        // Show
        for (int i = 0; i < tmp.length; i++) { // filas numbers.length
            for (int j = 0; j < tmp[0].length; j++) { // columnas numbers[0].length
                msg += tmp[i][j] + " ";
            }
            msg += "\n";
        }
        // Generate Auto-id
        msg += "Auto-id: ";
        String subId1 = "";
        String subId2 = "";
        String subId3 = "";

        boolean allSongs = true;
        boolean allPodcast = true;

        if (users.get(numberUser) instanceof Standard) {
            for (int i = 0; i < ((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist).getAudios()
                    .size(); i++) {

                if (((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist).getAudios()
                        .get(i) instanceof Song) {
                    allPodcast = false;
                } else if (((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist).getAudios()
                        .get(i) instanceof Podcast) {
                    allSongs = false;
                }

            }
        } else if (users.get(numberUser) instanceof Premium) {
            for (int i = 0; i < ((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist).getAudios()
                    .size(); i++) {

                if (((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist).getAudios()
                        .get(i) instanceof Song) {
                    allPodcast = false;
                } else if (((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist).getAudios()
                        .get(i) instanceof Podcast) {
                    allSongs = false;
                }
            }
        }

        if (allSongs) {
            for (int i = 0; i < tmp.length; i++) {
                subId1 += "" + tmp[tmp.length - (i + 1)][0];
                if (i > 0 && i < tmp.length - 1) {
                    subId2 += "" + tmp[i][i];
                }
                subId3 += "" + tmp[tmp.length - (i + 1)][tmp.length - 1];
            }
            msg += subId1 + subId2 + subId3;
        } else if (allPodcast) {

            for (int i = 0; i < tmp[0].length - 4; i++) {
                msg += tmp[0][i];
            }

            for (int i = 0; i < tmp.length; i++) {
                for (int j = 1; j < tmp[0].length; j++) {
                    if (j == (tmp.length / 2) - 1) {
                        msg += tmp[i][j];
                    }

                }
            }

            for (int i = tmp.length - 1; i >= 0; i--) {
                for (int j = 1; j < tmp[0].length; j++) {
                    if (j == (tmp.length / 2)) {
                        msg += tmp[i][j];
                    }

                }
            }

            for (int i = 4; i < tmp[0].length; i++) {
                msg += tmp[0][i];
            }
        } else {

            for (int i = tmp.length - 1; i >= 0; i--) {
                for (int j = tmp[0].length - 1; j >= 0; j--) {

                    if (i <= 5 && i >= 2) {
                        if (i % 2 != 0 && j % 2 == 0) {
                            msg += tmp[i][j];
                        } else if (i % 2 == 0 && j % 2 != 0) {
                            msg += tmp[i][j];
                        }

                    } else {
                        if (i == 1 && j % 2 == 0 && j != 0) {
                            msg += tmp[i][j];
                        } else if (i == 0 && j % 2 != 0 && j != 1) {
                            msg += tmp[i][j];
                        }
                    }

                }
            }
        }

        if (users.get(numberUser) instanceof Standard) {
            ((Standard) users.get(numberUser)).getPlaylists().get(numberPlaylist).setAutoId(msg);
        } else {
            ((Premium) users.get(numberUser)).getPlaylist().get(numberPlaylist).setAutoId(msg);
        }

        return msg;
    }

    /**
     * Description: Reproducer a Audio and your Ad if has
     * 
     * @param numberUser  The User that want reproducer a Audio
     * @param numberAudio The Audio that will be play
     * @return String of Playing
     */
    public String reproduceAudio(int numberUser, int numberAudio) {
        String msg = "";
        if (users.get(numberUser) instanceof Standard) {
            // Ad
            if (audios.get(numberAudio) instanceof Song) {
                ((Standard) users.get(numberUser)).setListenedSong(1);
                // Every two Song
                if (((Consumer) users.get(numberUser)).getListenedSong() % 2 == 0) {
                    msg += "\n" + Ad.values()[0].reproducer();
                }
            } else {
                // Always
                msg += "\n" + Ad.values()[0].reproducer();
                ((Standard) users.get(numberUser)).setListenedPodcast(1);
            }
        } else {
            // No Ad
            if (audios.get(numberAudio) instanceof Song) {
                ((Premium) users.get(numberUser)).setListenedSong(1);
            } else {
                ((Premium) users.get(numberUser)).setListenedPodcast(1);
            }
        }
        audios.get(numberAudio).setNumberReproduction(1);
        msg += "\n\n" + audios.get(numberAudio).reproducer();
        return msg;
    }

    /**
     * Description: The User selected buy a song selected
     * 
     * @param numberUser The User that want reproducer a Audio
     * @param numberSong The Song that will be buy
     * @return boolean
     */
    public boolean buySong(int numberUser, int numberSong) {
        Invoice newInvoice = new Invoice((Song) audios.get(numberSong));
        if (users.get(numberUser) instanceof Standard) {
            if (((Standard) users.get(numberUser)).getInvoices().size() < 101) {
                ((Song) audios.get(numberSong)).setAmountSale(1);
                return ((Standard) users.get(numberUser)).addInvoice(newInvoice);
            } else {
                return false;
            }
        } else {
            ((Song) audios.get(numberSong)).setAmountSale(1);
            return ((Premium) users.get(numberUser)).addInvoice(newInvoice);
        }
    }

    /**
     * Description: Show a report requested
     * 
     * @return String The report
     */
    public String totalReproductions() {
        String msg = "";
        int totalSongs = 0;
        int totalPodcast = 0;
        for (Audio audio : audios) {
            if (audio instanceof Song) {
                totalSongs += audio.getNumberReproduction();
            } else {
                totalPodcast += audio.getNumberReproduction();
            }
        }
        msg += "\n Total Reproduction Song: " + totalSongs + "\n Total Reproduction Podcast: " + totalPodcast
                + "\n Total: " + (totalPodcast + totalSongs);
        return msg;
    }

    /**
     * Description: Show a report requested
     * 
     * @return String The report
     */
    public String genreSong() {
        String msg = "";
        int[] typeGenre = new int[] { 0, 0, 0, 0 };
        for (Audio audio : audios) {
            if (audio instanceof Song) {
                if (((Song) audio).getTypeGenre() == TypeGenre.ROCK) {
                    typeGenre[0] += audio.getNumberReproduction();
                } else if (((Song) audio).getTypeGenre() == TypeGenre.POP) {
                    typeGenre[1] += audio.getNumberReproduction();
                } else if (((Song) audio).getTypeGenre() == TypeGenre.TRAP) {
                    typeGenre[2] += audio.getNumberReproduction();
                } else if (((Song) audio).getTypeGenre() == TypeGenre.HOUSE) {
                    typeGenre[3] += audio.getNumberReproduction();
                }
            }
        }
        int max = -1;
        int position = -1;
        for (int i : typeGenre) {
            if (i > max) {
                max = i;
            }
        }
        int contador = -1;
        for (int i : typeGenre) {
            contador += 1;
            if (max == i) {
                position = contador;
            }
        }
        msg += "\n The Genre most listened is " + TypeGenre.values()[position] + " with " + typeGenre[position]
                + " reproductions";
        return msg;
    }

    /**
     * Description: Show a report requested
     * 
     * @return String The report
     */
    public String categoryPodcast() {
        String msg = "";
        int[] typePodcast = new int[] { 0, 0, 0, 0 };
        for (Audio audio : audios) {
            if (audio instanceof Podcast) {
                if (((Podcast) audio).getTypeCategory() == TypeCategory.POLITIC) {
                    typePodcast[0] += audio.getNumberReproduction();
                } else if (((Podcast) audio).getTypeCategory() == TypeCategory.ENTERTAINMENT) {
                    typePodcast[1] += audio.getNumberReproduction();
                } else if (((Podcast) audio).getTypeCategory() == TypeCategory.VIDEOGAME) {
                    typePodcast[2] += audio.getNumberReproduction();
                } else if (((Podcast) audio).getTypeCategory() == TypeCategory.FASHION) {
                    typePodcast[3] += audio.getNumberReproduction();
                }
            }
        }
        int max = -1;
        int position = -1;
        for (int i : typePodcast) {
            if (i > max) {
                max = i;
            }
        }
        int contador = -1;
        for (int i : typePodcast) {
            contador += 1;
            if (max == i) {
                position = contador;
            }
        }
        msg += "\n The Category most listened is " + TypeCategory.values()[position] + " with " + typePodcast[position]
                + " reproductions";
        return msg;
    }

    /**
     * Description: Show the Song most buiest
     * 
     * @return String The report
     */
    public String top5() {
        return "En proceso...";
    }

    /**
     * Description: Show the Song most buiest
     * 
     * @return String The report
     */
    public String top10() {
        return "En proceso...";
    }

    /**
     * Description: Show the Song most buiest
     * 
     * @return String The report
     */
    public String boughtGenreSong() {

        String msg = "";
        int[] typeGenreSales = new int[] { 0, 0, 0, 0 };
        int[] typeGenreTotal = new int[] { 0, 0, 0, 0 };
        for (Audio audio : audios) {
            if (audio instanceof Song) {
                if (((Song) audio).getTypeGenre() == TypeGenre.ROCK) {
                    typeGenreSales[0] += ((Song) audio).getAmountSale();
                    typeGenreTotal[0] += ((Song) audio).getSaleValue() * ((Song) audio).getAmountSale();
                } else if (((Song) audio).getTypeGenre() == TypeGenre.POP) {
                    typeGenreSales[1] += ((Song) audio).getAmountSale();
                    typeGenreTotal[1] += ((Song) audio).getSaleValue() * ((Song) audio).getAmountSale();
                } else if (((Song) audio).getTypeGenre() == TypeGenre.TRAP) {
                    typeGenreSales[2] += ((Song) audio).getAmountSale();
                    typeGenreTotal[2] += ((Song) audio).getSaleValue() * ((Song) audio).getAmountSale();
                } else if (((Song) audio).getTypeGenre() == TypeGenre.HOUSE) {
                    typeGenreSales[3] += ((Song) audio).getAmountSale();
                    typeGenreTotal[3] += ((Song) audio).getSaleValue() * ((Song) audio).getAmountSale();
                }
            }
        }
        for (int i = 0; i < typeGenreSales.length; i++) {
            msg += "\n Type Genre " + TypeGenre.values()[i] + ", " + typeGenreSales[i]
                    + " amount sales and a value total of " + typeGenreTotal[i];
        }
        return msg;
    }

    /**
     * Description: Show the Song most buiest
     * 
     * @return String The report
     */
    public String songMostbuiest() {
        String msg = "";

        Audio mostBuiest = null;
        int max = -1;

        for (Audio audio : audios) {
            if (audio instanceof Song) {
                if (((Song) audio).getAmountSale() > max) {
                    mostBuiest = audio;
                    max = ((Song) audio).getAmountSale();
                }
            }
        }
        if (mostBuiest != null) {
            msg += "\nThe Song most buiest is " + mostBuiest.getName() + " with "
                    + ((Song) mostBuiest).getAmountSale() + " shopping and a value total of "
                    + ((Song) mostBuiest).getAmountSale() * ((Song) mostBuiest).getSaleValue();
        } else {
            msg += "\n There is/are Songs registered";
        }

        return msg;
    }
}
