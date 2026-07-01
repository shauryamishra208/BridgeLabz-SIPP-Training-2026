import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return name + " | " + phone + " | " + email;
    }
}

class AddressBook {
    private List<Contact> contacts;
    private Map<String, Contact> nameIndex;
    private Set<String> phoneSet;

    AddressBook() {
        contacts = new ArrayList<>();
        nameIndex = new HashMap<>();
        phoneSet = new HashSet<>();
    }

    boolean add(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number: " + phone + ". Contact not added.");
            return false;
        }
        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        nameIndex.put(name, contact);
        phoneSet.add(phone);
        return true;
    }

    Contact search(String name) {
        return nameIndex.get(name);
    }

    boolean delete(String name) {
        Contact contact = nameIndex.get(name);
        if (contact == null) {
            return false;
        }
        contacts.remove(contact);
        nameIndex.remove(name);
        phoneSet.remove(contact.phone);
        return true;
    }

    void displaySortedByName() {
        List<Contact> sorted = new ArrayList<>(contacts);
        Collections.sort(sorted, new Comparator<Contact>() {
            @Override
            public int compare(Contact a, Contact b) {
                return a.name.compareTo(b.name);
            }
        });
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}

public class AddressBookDemo {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        book.add("Charlie", "9111111111", "charlie@mail.com");
        book.add("Alice", "9222222222", "alice@mail.com");
        book.add("Bob", "9333333333", "bob@mail.com");
        book.add("Dave", "9222222222", "dave@mail.com");

        System.out.println("All contacts sorted by name:");
        book.displaySortedByName();

        System.out.println("Search 'Bob': " + book.search("Bob"));

        book.delete("Alice");
        System.out.println("After deleting Alice:");
        book.displaySortedByName();
    }
}
