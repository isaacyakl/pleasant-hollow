import Link from "next/link";

export default function ListedCategory({ id, title, description }: { id: string; title: string; description: string }) {
	return (
		<Link href={`/categories/${id}`} className="mb-2 w-full">
			<div className="w-full p-2 mb-4 last:m-0 border-2 rounded-md border-[#c2a878]">
				<h3 className="font-bold">{title}</h3>
				<p>{description}</p>
			</div>
		</Link>
	);
}
