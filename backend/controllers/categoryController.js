import Category from "../models/categoryModel.js";
import asyncHandler from "../middlewares/asyncHandler.js";

const createCategory = asyncHandler(async (req, res) => {
  try {
    const { name } = req.body;

    // if (!name) {
    //   return res.status(400).json({ error: "Name is required" });
    // }

    // const existingCategory = await Category.findOne({ name });

    // if (existingCategory) {
    //   return res.status(400).json({ error: "Already exists" });
    // }

    const category = await new Category({ name }).save();
    res.status(200).json(category);
  } catch (error) {
    console.log(error);
    return res.status(400).json(error);
  }
});

const updateCategory = asyncHandler(async (req, res) => {
  try {
    const { name } = req.body;
    const { categoryId } = req.params;

    // const category = await Category.findOne({ _id: categoryId });

    // if (!category) {
    //   return res.status(404).json({ error: "Category not found" });
    // }

    // category.name = name;

    // const updatedCategory = await category.save();
    // res.status(200).json(updatedCategory);
    const updatedCategory = await Category.findOneAndUpdate(
      { _id: categoryId },
      { name: name },
      { new: true }
    );
    res.status(200).json(updatedCategory);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal server error" });
  }
});

const removeCategory = asyncHandler(async (req, res) => {
  try {
    const removed = await Category.findByIdAndRemove(req.params.categoryId);
    res.json(removed);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal server error" });
  }
});

const listCategory = asyncHandler(async (req, res) => {
  try {
    const all = await Category.find({});
    res.status(200).json(all);
  } catch (error) {
    console.log(error);
    return res.status(400).json(error.message);
  }
});

const readCategory = asyncHandler(async (req, res) => {
  try {
    const category = await Category.findOne({ _id: req.params.id });
    res.status(200).json(category);
  } catch (error) {
    console.log(error);
    return res.status(400).json(error.message);
  }
});

export {
  createCategory,
  updateCategory,
  removeCategory,
  listCategory,
  readCategory,
};
