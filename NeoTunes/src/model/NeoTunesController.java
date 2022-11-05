package model;

import java.util.ArrayList;

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
    public String   showNickName(int standardOrPremiumOrArtistOrCreator) {
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
}
