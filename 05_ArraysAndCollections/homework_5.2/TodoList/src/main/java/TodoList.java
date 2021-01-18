import java.util.ArrayList;

public class TodoList {

  private ArrayList<String> arrayList = new ArrayList<>();

  public void add(String todo) {
    // TODO: добавьте переданное дело в конец списка
    arrayList.add(todo);
    System.out.println("Добавлено дело \"" + todo + "\"");
  }

  public void add(int index, String todo) {
    // TODO: добавьте дело на указаный индекс,
    //  проверьте возможность добавления
    if (index <= (arrayList.size()-1) && index >= 0) {
      arrayList.add(index, todo);
      System.out.println("Добавлено дело \"" + todo + "\"");
    } else if(index > arrayList.size()) {
      arrayList.add(todo);
      System.out.println("Добавлено дело \"" + todo + "\"");
    }

  }

  public void edit(String todo, int index) {
    // TODO: заменить дело на index переданным todo индекс,
    //  проверьте возможность изменения
      if (!(index >arrayList.size())) {
        System.out.println("Дело \"" + arrayList.get(index) + "\" заменено на " + "\"" + todo + "\"");
        arrayList.set(index, todo);
        // TODO: Почему то не срабатывает делет на введенный последний индекс
      } else {
        System.out.println("Введенный индекс находится за пределами списка");
        System.out.println("Введите индекс от 0" + " до " + (arrayList.size() - 1));
      }
    }


  public void delete(int index) {
    // TODO: удалить дело находящееся по переданному индексу,
    //  проверьте возможность удаления дела
    if (index < (arrayList.size() - 1) && index >= 0) {
      System.out.println("Дело \"" + arrayList.get(index) + "\" удалено ");
      arrayList.remove(index);
    } else {
      System.out.println("Введенный индекс находится за пределами списка");
      System.out.println("Введите индекс от 0" + " до " + (arrayList.size() - 1));
    }

  }

  public ArrayList<String> getTodos() {
    // TODO: вернуть список дел
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(i + " - " + arrayList.get(i));
    }
    return arrayList;
  }

}