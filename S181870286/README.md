## 代码原理

### 从图片载入类

首先，`BubbleSorter`字节码编码在图片中。  
`SteganographyClassLoader`接受图片的地址`URL`作为构造参数，在`findClass()`载入图片，并调用`SteganographyEncoder.decodeByteArray()`把字节码从图片中解码出来。 
有了类名和字节码，就能通过`ClassLoader.defineClass()`构造出`BubbleSorter`类出来，并且用这个类实例化一个对象。

### 把字节码编码进图片

主要分为`SteganographyFactory`和`SteganographyEncoder`两个部分。

`SteganographyFactory`负责找到Java源码，将其编译成字节码，再调用`SteganographyEncoder`的`encodeFile`方法将字节码编码进图片。

`SteganographyEncoder`负责具体的编码、解码工作。具体来说`SteganographyEncoder`有`bitsFromColor`参数，表示颜色分量的后多少位用来存储数据。在编码时，编码器将图片颜色分量的后几位抹去，将数据字节流中的比特按序放上。解码时同理，从颜色分量的后几位中取出比特，组成字节流。

## 我的图片

![](resources/S181870286.HeapSorter.png)

![](resources/S181870286.QuickSorter.png)

## 我的结果

[HeapSort](https://asciinema.org/a/439926)

[QuickSort](https://asciinema.org/a/439927)

## 使用同学的图片

由于我的W02作业修改了example的`Sorter`的接口，因此就算从同学的图片载入了类也和我代码接口不一致，因此这个任务放弃了。