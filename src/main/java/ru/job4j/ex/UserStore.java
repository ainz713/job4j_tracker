package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User e:
             users) {
            if (e.getUsername().equals(login)) {
                return e;
            } else {
                throw new UserNotFoundException("Пользователь не найден");
            }
        }
        return null;
    }

        public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валидный");
        } else {
        return true;
        }
        }

        public static void main(String[]args) {
            try {
                User[] users = {
                        new User("Petr Arsentev", true)
                };
                User user = findUser(users, "Petr Arsentev");
                if (validate(user)) {
                    System.out.println("This user has an access");
                }
            } catch (UserInvalidException e) {
                System.out.println("Пользователь не валидный");
            } catch (UserNotFoundException ea) {
                System.out.println("Пользователь не найден");
            }
        }
}
