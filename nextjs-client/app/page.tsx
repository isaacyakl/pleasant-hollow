"use client";
import { useEffect, useState } from "react";
import ListedCategory from "../components/Categories/ListedCategory";
import Ruler from "@/components/Ruler";
import Button from "@/components/Button";
import Link from "next/link";

export default function Home() {
	const [categories, setCategories] = useState([]);

	useEffect(() => {
		const getCategories = async () => {
			const res = await fetch("http://localhost:8082/api/v1/categories", { cache: "no-store" });

			if (!res.ok) {
				throw new Error("Failed to fetch data");
			}

			const returnedCategories = await res.json();
			const parentCategories = returnedCategories.filter((category: Category) => category.parentId === "" || category.parentId === null);
			setCategories(parentCategories);
		};
		getCategories();
	}, []);

	return (
		<main className="flex min-h-screen flex-col items-center justify-start p-8">
			<div className="w-full p-2">
				<h1 className="text-3xl text-center text-[#14281d] dark:text-[#c2a878]">Pleasant Hollow</h1>
				<p className="text-[#14281d] dark:text-[#f1f5f2] text-center">An end-to-end secure modern discussion board.</p>
			</div>
			<Ruler />
			<div className="flex w-full flex-wrap">
				<h2 className="w-full sm:w-1/2 text-2xl text-center sm:text-left self-center">Categories</h2>
				<div className="w-full sm:w-1/2 text-center sm:text-right self-center">
					<Link href="/categories/new">
						<Button>Create</Button>
					</Link>
				</div>
			</div>
			<div className="w-full flex flex-col items-start justify-start p-2">{categories.length === 0 ? "Retrieving categories..." : categories.map((category: Category) => <ListedCategory key={category.id} category={category} />)}</div>
		</main>
	);
}
