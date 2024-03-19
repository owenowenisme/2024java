.PHONY: always_run

%: always_run
	@if [ -d "$@" ]; then \
		echo "Zipping folder: $@"; \
		cd "$@"; \
		zip -r "F74116194.zip" .; \
	else \
		echo "Error: '$@' is not a valid directory"; \
	fi

always_run: