package Pet_Registry;

class Counter implements AutoCloseable {
    private static int count = 0;
    private boolean closed = false;

    public void add() {
        if (closed) {
            throw new IllegalStateException("Закрыто");
        }
        count++;
        System.out.println("Добавлено новое животное. Всего животных: " + count);
    }
    @Override
     public void close() throws Exception {
        if (closed) {
            throw new IllegalStateException("Закрыто");
        }
        closed = true;
        System.out.println("Ресурс закрыт корректно");
    }

    public static int getCount() {
        return count;
    }

}
