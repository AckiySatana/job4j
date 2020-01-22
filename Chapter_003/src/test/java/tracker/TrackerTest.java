package tracker;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 123L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeletedTrack() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "some description", 123L);
        tracker.add(item);
        boolean result = tracker.deleted(item.getId());
        assertThat(result, is(true));
    }

    @Test
    public void whenFindAllTrack() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "some description", 123L);
        Item item2 = new Item("test1", "some description", 123L);
        Item item3 = new Item("test1", "some description", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = Arrays.asList(item1, item2, item3);
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void Sort() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("aaa", "some description", 123L);
        Item item2 = new Item("ccc", "some description", 123L);
        Item item3 = new Item("bbb", "some description", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = Arrays.asList(item1, item3,item2);
        Collections.sort(tracker.findAll());
        assertThat(tracker.findAll(), is(result));
    }
    @Test
    public void SortRevers() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("aaa", "some description", 123L);
        Item item2 = new Item("ccc", "some description", 123L);
        Item item3 = new Item("bbb", "some description", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = Arrays.asList(item2, item3,item1);
        Collections.sort(tracker.findAll(), new SortByItem());
        assertThat(tracker.findAll(), is(result));
    }


    @Test
    public void whenFindByNameTrack() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "some description", 123L);
        Item item1 = new Item("test1", "some description", 123L);
        Item item2 = new Item("test2", "some description", 123L);
        Item item3 = new Item("test3", "some description", 123L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = {item, item1};
        assertThat(tracker.findById(item.getId()).getName(), is(item.getName()));
    }

    @Test
    public void whenFindByIdTracker() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "some description", 123L);
        Item item2 = new Item("test1", "some description", 123L);
        Item item3 = new Item("test1", "some description", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }
}