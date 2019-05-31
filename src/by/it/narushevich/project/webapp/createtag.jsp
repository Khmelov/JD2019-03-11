<%@ page contentType="text/html;
    charset=UTF-8"
    language="java"
    pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<br>

<form class="form-horizontal" action="do?command=CreateTag" method="post">
<fieldset>

<!-- Form Name -->
<legend>Создание нового элемента вашей коллекции</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="trademark list">Список торговых марок</label>
  <div class="col-md-4">
    <select id="trademark list" name="trademark list" class="form-control">
      <option>Выберите из списка</option>
      <option value="AHMAD TEA">Ahmad tea</option>
      <option value="AKBAR">Akbar</option>
      <option value="ALATTAR">Alattar</option>
      <option value="AUCHAN">Auchan</option>
      <option value="BROOKE BOND">Brooke Bond</option>
      <option value="CHELTON">Chelton</option>
      <option value="DILMAH">Dilmah</option>
      <option value="FOREST OF ARDEN">Forest of Arden</option>
      <option value="GOLDEN BOWL">Golden Bowl</option>
      <option value="GREENFIELD">Greenfield</option>
      <option value="JAF TEA">Jaf tea</option>
      <option value="KAKOO">Kakoo</option>
      <option value="LIPTON">Lipton</option>
      <option value="LORD NELSON">Lord Nelson</option>
      <option value="MABROC">Mabroc</option>
      <option value="MAITRE DE THE">Maitre de The</option>
      <option value="MALWA">Malwa</option>
      <option value="MESSMER">Messmer</option>
      <option value="MISTRAL">Mistral</option>
      <option value="NATURSAN">Natursan</option>
      <option value="PICKWICK">Pickwick</option>
      <option value="PRINCESS JAVA">Princess Java</option>
      <option value="TEA">Tea</option>
    </select>
    <span class="help-block">если нужного нет - оставьте поле пустым</span>
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="trademark"></label>
  <div class="col-md-4">
  <input id="trademark" name="trademark" type="text" placeholder="МАРКА ЧАЯ" class="form-control input-md">
  <span class="help-block">введите торговую марку</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="subtitle">Подзаголовок</label>
  <div class="col-md-4">
  <input id="subtitle" name="subtitle" type="text" value="черный чай" placeholder="" class="form-control input-md">
  <span class="help-block">что еще написано на ярлычке?</span>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="material">Материал</label>
  <div class="col-md-4">
    <select id="material" name="material" class="form-control">
      <option value="cardboard">картон</option>
      <option value="paper">бумага</option>
      <option value="plastic">пластик</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="width">Ширина, мм</label>
  <div class="col-md-4">
  <input id="width" name="width" type="text" value="25" placeholder="" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="height">Высота, мм</label>
  <div class="col-md-4">
  <input id="height" name="height" type="text" value="28" placeholder="" class="form-control input-md">
  </div>
</div>

<!-- Date input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="in collection">В коллекции с</label>
  <div class="col-md-4">
  <input id="in collection" name="in collection" type="text" value="2005-07-04" placeholder="" class="form-control input-md">
    <span class="help-block">Дата в формате ГГГГ-ММ-ДД</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="number in catalog">Номер в каталоге</label>
  <div class="col-md-4">
  <input id="number in catalog" name="number in catalog" type="text" value="02-05-4" placeholder="" class="form-control input-md">
  </div>
</div>

<!-- File Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="picture">Изображение</label>
  <div class="col-md-4">
    <input id="picture" name="picture" class="input-file" type="file">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="create"></label>
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">Создать</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>