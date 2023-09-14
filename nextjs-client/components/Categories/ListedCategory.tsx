import getSubcategories from "@/lib/getSubcategories";
import Link from "next/link";
import { useEffect, useState } from "react";

export default function ListedCategory({ category }: { category: Category }) {
	const { id, title, description } = category;
	const [subCats, setSubCats] = useState([]);
	useEffect(() => {
		const getSubcats = async () => {
			const returnedCategories = await getSubcategories(id);
			setSubCats(returnedCategories);
		};

		getSubcats();
	}, []);

	return (
		<Link href={`/categories/${id}`} className="mb-2 w-full">
			<div className="w-full p-2 mb-4 last:m-0 border-2 rounded-md border-[#c2a878]">
				<h3 className="font-bold">{title}</h3>
				<p>{description}</p>
				{subCats.length > 0 && (
					<div className="ml-4 mt-4">
						{/* <h4 className="text-xl my-4">Subcategories</h4> */}
						{subCats.map((subCat: Category) => (
							<ListedCategory key={subCat.id} category={subCat} />
						))}
					</div>
				)}
			</div>
		</Link>
	);
}
