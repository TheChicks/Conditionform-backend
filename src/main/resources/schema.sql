CREATE TABLE IF NOT EXISTS PILL (
      id INT PRIMARY KEY AUTO_INCREMENT,
      medi_ko_name TEXT NOT NULL,
      medi_en_name TEXT NULL,
      link TEXT NULL,
      image_url TEXT NULL,
      category_welfare TEXT NULL,
      assortment TEXT NULL,
      manufacture_assort TEXT NULL,
      manufacture_assort_manufacturer TEXT NULL,
      insurance_code INT NULL,
      pregnant_rating TEXT NULL,
      age_prohibit TEXT NULL,
      shape_Info_appearance TEXT NULL,
      shape_info_formulation TEXT NULL,
      shape_info_shape TEXT NULL,
      shape_info_color TEXT NULL,
      shape_info_idmark TEXT NULL,
      ingredient_info TEXT NULL,
      storagint_method TEXT NULL,
      efficacy TEXT NULL,
      dosage TEXT NULL,
      precaution TEXT NULL
       )DEFAULT CHARSET=utf8;