"use client";
import Ruler from "@/components/Ruler";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import CategoryEditor from "@/components/Categories/CategoryEditor";
import Button from "@/components/Button";
import Link from "next/link";

export default function Page({ params }: { params: { id: string } }) {
	const router = useRouter();
	const [category, setCategory] = useState<Category>({ id: "", parentId: "", isEnabled: false, title: "", description: "", viewCount: 0 });
	const [showEditor, setShowEditor] = useState(false);

	useEffect(() => {
		const getCategory = async () => {
			const res = await fetch("http://localhost:8082/api/v1/categories/" + params.id, { cache: "no-store" });

			if (!res.ok) {
				throw new Error("Failed to fetch data");
			}

			setCategory(await res.json());
		};
		getCategory();
	}, []);

	const deleteCategory = async () => {
		const res = await fetch("http://localhost:8082/api/v1/categories/" + params.id, { method: "DELETE" });

		if (!res.ok) {
			throw new Error("Failed to delete category");
		}

		router.push("/");
	};

	const editCategory = () => {
		setShowEditor((current) => !current);
	};

	const cancelCategory = () => {
		setShowEditor(false);
	};

	const updateCategory = async (updatedCategory: Category) => {
		const res = await fetch("http://localhost:8082/api/v1/categories/" + category.id, {
			method: "PUT",
			headers: { "content-type": "application/json" },
			body: JSON.stringify({
				title: updatedCategory.title,
				isEnabled: updatedCategory.isEnabled,
				description: updatedCategory.description,
			}),
		});
		if (!res.ok) {
			throw new Error("Failed to update category");
		}
		setShowEditor(false);
		setCategory(updatedCategory);
	};

	return (
		<>
			<p className="text-xs">Category</p>
			<h1 className="text-3xl">{category.title}</h1>
			<div className="w-full flex flex-row">
				<Button onClick={editCategory}>Edit</Button>
				<Button onClick={deleteCategory}>Delete</Button>
			</div>
			{showEditor && <CategoryEditor category={category} handleSave={updateCategory} cancelAction={cancelCategory} />}
			<Ruler />
			<p className="text-xs">Views: {category.viewCount}</p>
			<p className="text-xs">{category.isEnabled ? "Enabled" : "Disabled"}</p>
			<p className="text-xs">ID: {category.id}</p>
			<Ruler />
			<p>{category.description}</p>
			<Ruler />
			<div className="flex w-full flex-wrap">
				<h2 className="w-full sm:w-1/2 text-2xl text-center sm:text-left self-center">Posts</h2>
				<div className="w-full sm:w-1/2 text-center sm:text-right self-center">
					<Link href={`/posts/new?category=${category.id}`}>
						<Button>Create</Button>
					</Link>
				</div>
			</div>
		</>
	);
}
