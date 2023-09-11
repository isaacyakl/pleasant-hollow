function Category({ title, description }: { title: string; description: string }) {
	return (
		<div className="p-2">
			<h3>{title}</h3>
			<p>{description}</p>
		</div>
	);
}

export default Category;
