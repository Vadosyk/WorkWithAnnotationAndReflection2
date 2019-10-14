package ua.kiev.prog;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.io.*;

public class Saver {

    ArrayList<TextContainer> TextContainerList = new ArrayList<TextContainer>();
    String phrase = "I very like Java!";
    String phrase1 = "I don^t like Delphi!";
    String phrase2 = "I don^t like PHP!";
    public void addTextToContainerList() {
            this.TextContainerList.add(new TextContainer(phrase));
            this.TextContainerList.add(new TextContainer(phrase1));
            this.TextContainerList.add(new TextContainer(phrase2));
    }

    public void save(String paramFolder) {
        for (int i = 0; i < this.TextContainerList.size(); i++) {
            File folded = new File(paramFolder);

            File file = new File(paramFolder + "\\" + i + ".txt");

            System.out.println(paramFolder + i + ".txt");
            try {
                if (!folded.exists()) {
                    folded.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                PrintWriter pw = new PrintWriter(file.getAbsoluteFile());
                try {
                    System.out.println(TextContainerList.get(i).text);
                    pw.println(TextContainerList.get(i).text);
                } catch (Exception e) {

                } finally {
                    pw.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @AnnFolder(paramFolder = "D:\\Test1", methodName = "save")
    public void saveMethod(String paramFolder, String methodName) {

        final Class<?> cls = Saver.class;
        Saver obj = new Saver();

        try {
            Method method = cls.getMethod("addTextToContainerList");
            method.invoke(obj);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        try {
            Class<?>[] paramTypes = new Class<?>[]{String.class};
            Method method = cls.getMethod(methodName, paramTypes);
            Object[] arguments = new Object[]{paramFolder};
            method.invoke(obj, arguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

