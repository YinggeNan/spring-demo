### XMLHttpRequest
1. 无法用来跨域请求
2. [跨域请求概念](https://juejin.cn/post/6996686880389627918)
    0. 协议相同
    1. 主机相同
    2. 端口相同
3. [参考](https://wangdoc.com/javascript/bom/xmlhttprequest.html#xmlhttprequestwithcredentials)
4. windows本地点击html文件 ajax-demo.html ,默认是无法完成跳转的,因为浏览器的同源策略, file的形式打开 ip:port 和要跳转的
   ip:port不同
5. 如果采用点击 IDEA提供的本地浏览器服务图标,则 ip:port 是 http://localhost:63342/
6. client 请求 server 时的 request 的 header 属性 Referer
    0. 意义: 告诉服务器我是从哪个页面链接过来的
    1. 作用:
        0. 防盗链: 比如办事通服务器只允许网站访问自己的静态资源，那服务器每次都需要判断Referer的值是否是zwfw.yn.gov.cn，如果是就继续访问，不是就拦截
        1. 防止恶意请求: 比如静态请求是.html结尾的，动态请求是.shtml，那么所有的*.shtml请求，必须
           Referer为我自己的网站才可以访问，这就是Referer的作用
    2. 空 Referer:当一个请求并不是由链接触发产生的，那么自然也就不需要指定这个请求的链接来源
        0. 直接在浏览器的地址栏中输入一个资源的URL地址，那么这种请求是不会包含Referer字段的
        1. windows本地点击 html 文件也没有 Referer
    3. 页面手动添加Referer元素: meta referrer标签

```
<meta name="referrer" content="none">
```

7. Referrer Policy: strict-origin-when-cross-origin

### dom操作

1. 四种操作
    0. 更新: 定位到节点,更新节点内容
    1. 遍历: 定位到节点,遍历其子节点
    2. 添加: 定位到节点,给其添加一个子节点
    3. 删除: 定位到节点,并删除该节点及其子节点

#### dom定位

1. 三种定位方式
    0. 根据 id 属性定位到唯一节点: document.getElementById()
    1. 根据 html 标签 定位一组节点: document.getElementsByTagName()
    2. 根据 class 属性定位一组节点: document.getElementsByClassName()
2. [使用 selector 定位节点](https://www.w3schools.com/jsref/met_document_queryselector.asp)
    0. 根据 css selector 定位符合条件的 第一个节点: document.querySelector 或 element.querySelector

```
// 通过querySelector获取ID为q1的节点：
var q1 = document.querySelector('#q1');
```

1. 根据 css selector 定位指定符合条件的所有节点:
   document.[querySelectorAll](https://developer.mozilla.org/en-US/docs/Web/API/Document/querySelectorAll) 或
   element.querySelectorAll

```
// 通过querySelectorAll获取q1节点内的符合条件的所有节点：
var ps = q1.querySelectorAll('div.highlighted > p');
```

2. 注意 document是默认根节点元素, element是我们已经拿到的dom节点元素
3. [css selector规则](https://www.w3school.com.cn/cssref/css_selectors.asp)
    0. 一般形式
        0. 标签选择器: div、p、span、button等
        1. class选择器: .<className>
        2. id选择器: #<idName>
        3. 其他属性选择器: [<attrName>=<attrVal>]
    1. and 限制关系: 两个选择器紧贴在一起
        0. .class1.class2: 选择 class 属性中同时有 name1 和 name2 的所有元素
        1. element.class: 选择所有标签为element且同时class选择器值中有class的元素
        2. element[<attrName>]: 选择所有标签为element且同时有属性<attrName>的元素
    2. or 限制关系: 逗号分割
        0. element1,element2: 选择所有标签为element1或element2的元素
        1. element,.class1: 选择所有标签为element1或class="class1"的元素
    3. 祖宗关系(不是直接的父子关系): 空格
        0. .class1 .class2: 选择作为类名 name1 元素后代的所有类名 name2 元素。
        1. element1 element2:选择element1中的所有element2
    4. 父子关系: 大于符号
        0. .class1>.class2:选择作为类名 name1 元素的直接子元素中所有类名 name2 的元素。
        1. element1>element2:选择element1的直接子元素中所有标签为 element2 的元素
    5. 一般属性值的selector
        0. 有某个属性： [attribute]
        1. 指定属性值: [attribute=value]
        2. 属性值包含某个字符串: [attribute*=value] 或 [attribute~=value],这种不生效目前
        3. 属性值以某个字符串开头: [attribute^=value] 或 [attribute|=value]
        4. 属性值以某个字符串结尾: [attribute$=value]
    6. 针对直接子元素
        0. 第一个孩子:    p:first-child
        1. 最后一个孩子: p:last-child
        2. 第n个孩子: p:nth-child(2),这里是第二个孩子
        3. 倒数第n个孩子: p:nth-last-child(2),这里是倒数第二个孩子
        4. 所有孩子: children
    7. 针对链接
4. css selector例子

| 选择器语法               | 语法例子          | 例子描述                                                                  |
|---------------------|---------------|-----------------------------------------------------------------------|
| .class              | .int*r*o      | 选择 class="intro" 的所有元素                                                |
| .class1.class2      | .name1.name2  | 选择 class 属性中同时有 name1 和 name2 的所有元素                                   |
| .class1 .class2     | .name1 .name2 | 选择作为类名 name1 元素后代(所有后代,不仅仅是直接子元素)的所有类名 name2 元素                       |
| #id                 | #firstname    | 选择 id="firstname" 的元素                                                 |
| *                   | *             | 选择所有元素                                                                |
| element             | p             | 选择所有 <p> 元素                                                           |
| element.class       | p.intro       | 选择 class="intro" 的所有 <p> 元素                                           |
| element1,element2   | div,p         | 选择所有 <div> 元素和所有 <p> 元素                                               |
| element1 element2   | div p         | 选择 <div> 元素内的所有 <p> 元素,这里的p只需要是div的子元素即可,不需要是直接子元素                    |
| .class element2     | .intro p      | 选择 class="intro" 元素内的所有 <p> 元素,这里的p只需要是 class="intro" 的子元素即可,不需要是直接子元素 |
| element1 > element2 | div>p         | 选择所有div的直接子元素中的所有p标签                                                  |
| .class >.class      | .p1>.p2       | 选择 class="p1"的所有直接子元素中的class="p2"的所有元素                                |
| element             | .p1>.p2       | 选择 class="p1"的所有直接子元素中的class="p2"的所有元素                                |
| element1+element2   | div + p       | 选择紧跟 <div> 元素的首个 <p> 元素                               |

5. 定位节点例子

```
// 返回ID为'test'的节点：
var test = document.getElementById('test');

// 先定位ID为'test-table'的节点，再返回其内部所有tr节点：
var trs = document.getElementById('test-table').getElementsByTagName('tr');

// 先定位ID为'test-div'的节点，再返回其内部所有class包含red的节点：
var reds = document.getElementById('test-div').getElementsByClassName('red');

// 获取节点test下的所有直属子节点:
var cs = test.children;

// 获取节点test下第一个、最后一个子节点：
var first = test.firstElementChild;
var last = test.lastElementChild;
```

#### dom更新节点
1. [修改节点](https://www.liaoxuefeng.com/wiki/1022910821149312/1023024977411904)
2. 读取节点: 节点属性innerHTML、innerText、textContent
3. 更新节点内容:
    0. innerHTML: 不但可以修改一个DOM节点的文本内容，还可以直接通过HTML片段修改DOM节点内部的子树
    1. 所以用innerHTML时,如果html内容是从网络拿到的,要注意防范 XSS攻击
    2. innerText、textContent,这样可以自动对字符串进行HTML编码，保证无法设置任何HTML标签
4. 更新节点css:直接修改节点的 style 属性的对应 css, 像 font-size 这种 css 名字,使用js修改时,用驼峰命令代替
```
// 获取<p id="p-id">...</p>
var p = document.getElementById('p-id');
// 设置CSS:
p.style.color = '#ff0000';
p.style.fontSize = '20px';
p.style.paddingTop = '2em';
```

#### dom插入节点
1. 方式
   0. 修改innerHTML
   1. appendChild:把一个子节点添加到父节点的最后一个子节点
   1.0 注意:如果一个节点已经存在于当前的dom树中,把这个node当作 appendChild的参数时,会先把这个节点从原先的位置删除，再插入到新的位置。
```
// 
var js = document.getElementById('js'),
list = document.getElementById('list');
list.appendChild(js);
```
   2. insertBefore:插入到指定位置
#### dom删除节点
1.定位到节点自己 self,父节点 parent, 调用 parent.removeChild(self) 即可

### AJAX

### Promise